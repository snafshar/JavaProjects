import java.util.*;

record StudyTask(String title, int minutes, boolean completed) {}

public class StudyPlanner {
    static List<StudyTask> incompleteByDuration(List<StudyTask> tasks) {
        return tasks.stream()
            .filter(task -> !task.completed())
            .sorted(Comparator.comparingInt(StudyTask::minutes)
                .thenComparing(StudyTask::title))
            .toList();
    }

    static int remainingMinutes(List<StudyTask> tasks) {
        return tasks.stream()
            .filter(task -> !task.completed())
            .mapToInt(StudyTask::minutes)
            .sum();
    }

    public static void main(String[] args) {
        var tasks = List.of(
            new StudyTask("Algorithms", 45, false),
            new StudyTask("Review", 20, true),
            new StudyTask("Networking", 60, false)
        );
        System.out.println("Incomplete tasks: " + incompleteByDuration(tasks));
        System.out.println("Remaining minutes: " + remainingMinutes(tasks));
    }
}
