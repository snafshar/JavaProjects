import java.util.Objects;

public final class Task {
    private final long id;
    private final String title;
    private final TaskStatus status;

    public Task(long id, String title, TaskStatus status) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        this.id = id;
        this.title = title.trim();
        this.status = Objects.requireNonNull(status, "status");
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }

    public Task withStatus(TaskStatus nextStatus) {
        return new Task(id, title, nextStatus);
    }

    @Override
    public String toString() {
        return String.format("#%d [%s] %s", id, status, title);
    }
}
