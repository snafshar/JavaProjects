public final class ThroughputCalculator {
    private ThroughputCalculator() {}

    public static double megabitsPerSecond(long bytes, double seconds) {
        if (bytes < 0 || seconds <= 0) {
            throw new IllegalArgumentException("invalid transfer parameters");
        }
        return bytes * 8.0 / seconds / 1_000_000.0;
    }

    public static void main(String[] args) {
        System.out.printf("%.2f Mbps%n", megabitsPerSecond(125_000_000L, 10));
    }
}
