import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;

public final class TaskStore {
    private final Path file;

    public TaskStore(Path file) {
        this.file = file.toAbsolutePath();
    }

    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(file)) {
            return tasks;
        }
        int lineNumber = 0;
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            lineNumber++;
            if (line.isBlank()) continue;
            String[] fields = line.split("\\t", -1);
            if (fields.length != 3) {
                throw new IOException("Invalid task record at line " + lineNumber);
            }
            try {
                long id = Long.parseLong(fields[0]);
                TaskStatus status = TaskStatus.valueOf(fields[1]);
                String title = new String(Base64.getDecoder().decode(fields[2]), StandardCharsets.UTF_8);
                tasks.add(new Task(id, title, status));
            } catch (RuntimeException error) {
                throw new IOException("Invalid task record at line " + lineNumber, error);
            }
        }
        tasks.sort(Comparator.comparingLong(Task::getId));
        return tasks;
    }

    public void save(List<Task> tasks) throws IOException {
        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);
        Path temporary = Files.createTempFile(parent, "tasktrail-", ".tmp");
        try {
            List<String> lines = new ArrayList<>();
            for (Task task : tasks) {
                String encoded = Base64.getEncoder().encodeToString(
                    task.getTitle().getBytes(StandardCharsets.UTF_8));
                lines.add(task.getId() + "\t" + task.getStatus().name() + "\t" + encoded);
            }
            Files.write(temporary, lines, StandardCharsets.UTF_8);
            try {
                Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING,
                           StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException unsupported) {
                Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporary);
        }
    }
}
