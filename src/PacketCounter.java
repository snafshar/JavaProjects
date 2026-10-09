public final class PacketCounter {
    private int sent;
    private int received;

    public void sent() { sent++; }
    public void received() { received++; }

    public int lost() { return sent - received; }
    public double lossPercent() {
        return sent == 0 ? 0.0 : 100.0 * lost() / sent;
    }
}
