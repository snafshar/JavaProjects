import java.util.*;
import java.util.stream.*;

record Measurement(String device, double value) {}

public class Measurements {
    static Map<String, Double> averages(List<Measurement> data) {
        return data.stream().collect(Collectors.groupingBy(
            Measurement::device,
            TreeMap::new,
            Collectors.averagingDouble(Measurement::value)
        ));
    }

    static OptionalDouble overallAverage(List<Measurement> data) {
        return data.stream().mapToDouble(Measurement::value).average();
    }

    public static void main(String[] args) {
        var data = List.of(
            new Measurement("cpu", 42),
            new Measurement("cpu", 58),
            new Measurement("ram", 70),
            new Measurement("ram", 64),
            new Measurement("network", 18)
        );
        System.out.println("Averages by device: " + averages(data));
        System.out.println("Overall average: " +
            overallAverage(data).orElse(Double.NaN));
    }
}
