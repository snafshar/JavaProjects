/** Computes packets per second from a count and elapsed duration. */
public final class PacketRate {
    private PacketRate() {}
    public static double perSecond(long packets, double seconds) {
        if (packets < 0 || seconds <= 0.0) throw new IllegalArgumentException("invalid measurement");
        return packets / seconds;
    }
}
