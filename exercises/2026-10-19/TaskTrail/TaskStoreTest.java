import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class TaskStoreTest {
    public static void main(String[] args) throws IOException {
        Path dir = Files.createTempDirectory("tasktrail-test-");
        Path file = dir.resolve("tasks.tsv");
        try {
            TaskStore store = new TaskStore(file);
            store.save(List.of(
                new Task(1, "Review Java code", TaskStatus.OPEN),
                new Task(2, "Read tabs\tand unicode ✓", TaskStatus.DONE)
            ));
            List<Task> loaded = store.load();
            assert loaded.size() == 2 : "expected two saved tasks";
            assert loaded.get(0).getTitle().equals("Review Java code");
            assert loaded.get(1).getTitle().equals("Read tabs\tand unicode ✓");
            assert loaded.get(1).getStatus() == TaskStatus.DONE;
            System.out.println("TaskStore tests passed.");
        } finally {
            Files.deleteIfExists(file);
            Files.deleteIfExists(dir);
        }
    }
}
