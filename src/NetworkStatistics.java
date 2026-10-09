public final class NetworkStatistics {
    private NetworkStatistics() {}
    public static double packetLossPercent(int sent, int received) {
        if (sent < 0 || received < 0 || received > sent)
            throw new IllegalArgumentException("invalid packet counts");
        return sent == 0 ? 0.0 : 100.0 * (sent - received) / sent;
    }
}
