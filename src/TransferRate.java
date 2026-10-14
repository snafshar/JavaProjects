/** Converts byte counts and elapsed seconds into decimal megabits per second. */
public final class TransferRate {
    private TransferRate() {}
    public static double megabitsPerSecond(long bytes, double seconds) {
        if (bytes < 0 || seconds <= 0.0) throw new IllegalArgumentException("invalid measurement");
        return bytes * 8.0 / seconds / 1_000_000.0;
    }
}
