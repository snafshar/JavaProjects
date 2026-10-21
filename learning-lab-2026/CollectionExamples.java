import java.util.ArrayList;
import java.util.List;

public class CollectionExamples {
    public static List<String> nonBlank(List<String> values) {
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if (value != null && !value.isBlank()) result.add(value.trim());
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(nonBlank(List.of("alpha", "", " beta ")));
    }
}