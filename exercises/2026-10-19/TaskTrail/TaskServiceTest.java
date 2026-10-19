import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TaskServiceTest {
    public static void main(String[] args) throws IOException {
        Path dir = Files.createTempDirectory("tasktrail-service-");
        try {
            TaskService service = new TaskService(new TaskStore(dir.resolve("tasks.tsv")));
            Task first = service.add("First task");
            Task second = service.add("Second task");
            assert first.getId() == 1;
            assert second.getId() == 2;
            assert service.list().size() == 2;
            assert service.markDone(1).getStatus() == TaskStatus.DONE;
            assert service.list().get(0).getStatus() == TaskStatus.DONE;
            boolean missingRejected = false;
            try { service.markDone(999); }
            catch (IllegalArgumentException expected) { missingRejected = true; }
            assert missingRejected;
            System.out.println("TaskService tests passed.");
        } finally {
            Files.deleteIfExists(dir.resolve("tasks.tsv"));
            Files.deleteIfExists(dir);
        }
    }
}
