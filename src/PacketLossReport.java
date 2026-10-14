/** Immutable packet delivery summary. */
public final class PacketLossReport {
    private final long sent;
    private final long received;
    public PacketLossReport(long sent, long received) {
        if (sent < 0 || received < 0 || received > sent) throw new IllegalArgumentException("invalid counts");
        this.sent = sent; this.received = received;
    }
    public long lost() { return sent - received; }
    public double lossPercent() { return sent == 0 ? 0.0 : lost() * 100.0 / sent; }
}
