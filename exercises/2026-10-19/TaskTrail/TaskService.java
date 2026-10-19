import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class TaskService {
    private final TaskStore store;

    public TaskService(TaskStore store) {
        this.store = store;
    }

    public Task add(String title) throws IOException {
        List<Task> tasks = store.load();
        long nextId = tasks.stream().mapToLong(Task::getId).max().orElse(0L) + 1L;
        Task task = new Task(nextId, title, TaskStatus.OPEN);
        tasks.add(task);
        store.save(tasks);
        return task;
    }

    public List<Task> list() throws IOException {
        List<Task> tasks = new ArrayList<>(store.load());
        tasks.sort(Comparator.comparingLong(Task::getId));
        return tasks;
    }

    public Task markDone(long id) throws IOException {
        List<Task> tasks = store.load();
        for (int index = 0; index < tasks.size(); index++) {
            Task existing = tasks.get(index);
            if (existing.getId() == id) {
                Task updated = existing.withStatus(TaskStatus.DONE);
                tasks.set(index, updated);
                store.save(tasks);
                return updated;
            }
        }
        throw new IllegalArgumentException("No task with id " + id);
    }
}
