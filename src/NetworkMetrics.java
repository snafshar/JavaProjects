import java.util.*;

public class NetworkMetrics {
    static double average(int[] values) {
        return Arrays.stream(values).filter(v -> v < Integer.MAX_VALUE).average().orElse(0);
    }
    public static void main(String[] args) {
        int[] latencyMs = {12, 15, 11, 19, 14, 17};
        System.out.printf("Samples: %d%nAverage latency: %.2f ms%n", latencyMs.length, average(latencyMs));
        System.out.printf("Minimum latency: %d ms%n", Arrays.stream(latencyMs).min().orElse(0));
        System.out.printf("Maximum latency: %d ms%n", Arrays.stream(latencyMs).max().orElse(0));
    }
}
