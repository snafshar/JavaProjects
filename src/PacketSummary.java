/** Minimal immutable summary of a network measurement. */
public final class PacketSummary {
    private final long bytes;
    private final double seconds;

    public PacketSummary(long bytes, double seconds) {
        if (bytes < 0 || seconds <= 0) throw new IllegalArgumentException("invalid measurement");
        this.bytes = bytes;
        this.seconds = seconds;
    }

    public double megabitsPerSecond() { return bytes * 8.0 / seconds / 1_000_000.0; }
    public long bytes() { return bytes; }
    public double seconds() { return seconds; }
}
