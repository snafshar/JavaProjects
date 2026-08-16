import java.util.*;
record StudyTask(String title,int minutes,boolean completed){}
public class StudyPlanner {
 public static List<StudyTask> incompleteByDuration(List<StudyTask> tasks){return tasks.stream().filter(t->!t.completed()).sorted(Comparator.comparingInt(StudyTask::minutes)).toList();}
 public static void main(String[] args){System.out.println(incompleteByDuration(List.of(new StudyTask("Algorithms",45,false),new StudyTask("Review",20,true))));}
}