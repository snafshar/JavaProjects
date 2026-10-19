import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public final class TaskTrail {
    private TaskTrail() { }

    public static void main(String[] args) {
        Path file = Path.of(System.getenv().getOrDefault("TASKTRAIL_FILE", "tasks.tsv"));
        TaskService service = new TaskService(new TaskStore(file));
        try {
            if (args.length == 0) {
                usage();
                System.exit(2);
            }
            switch (args[0]) {
                case "add" -> {
                    if (args.length < 2) {
                        usage();
                        System.exit(2);
                    }
                    String title = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
                    System.out.println("Added " + service.add(title));
                }
                case "list" -> {
                    requireLength(args, 1);
                    List<Task> tasks = service.list();
                    if (tasks.isEmpty()) System.out.println("No tasks yet.");
                    else tasks.forEach(System.out::println);
                }
                case "done" -> {
                    requireLength(args, 2);
                    long id = Long.parseLong(args[1]);
                    System.out.println("Updated " + service.markDone(id));
                }
                default -> {
                    usage();
                    System.exit(2);
                }
            }
        } catch (IllegalArgumentException error) {
            System.err.println("Error: " + error.getMessage());
            System.exit(2);
        } catch (IOException error) {
            System.err.println("Storage error: " + error.getMessage());
            System.exit(1);
        }
    }

    private static void requireLength(String[] args, int expected) {
        if (args.length != expected) throw new IllegalArgumentException("unexpected arguments");
    }

    private static void usage() {
        System.err.println("Usage: java TaskTrail.java add \"TITLE\" | list | done ID");
    }
}
