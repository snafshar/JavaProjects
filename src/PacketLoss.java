/** Packet-loss percentage helper for networking examples. */
public final class PacketLoss {
    private PacketLoss() {}

    public static double percent(long sent, long received) {
        if (sent < 0 || received < 0 || received > sent)
            throw new IllegalArgumentException("require 0 <= received <= sent");
        if (sent == 0) return 0.0;
        return 100.0 * (sent - received) / sent;
    }
}
