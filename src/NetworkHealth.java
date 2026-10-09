public final class NetworkHealth {
    private final double latencyMs;
    private final double packetLossPercent;

    public NetworkHealth(double latencyMs, double packetLossPercent) {
        if (latencyMs < 0) {
            throw new IllegalArgumentException("latencyMs must be non-negative");
        }
        if (packetLossPercent < 0 || packetLossPercent > 100) {
            throw new IllegalArgumentException("packetLossPercent must be between 0 and 100");
        }
        this.latencyMs = latencyMs;
        this.packetLossPercent = packetLossPercent;
    }

    public String status() {
        if (packetLossPercent >= 10 || latencyMs >= 200) return "poor";
        if (packetLossPercent >= 2 || latencyMs >= 100) return "degraded";
        return "healthy";
    }

    public double latencyMs() { return latencyMs; }
    public double packetLossPercent() { return packetLossPercent; }

    public static void main(String[] args) {
        NetworkHealth health = new NetworkHealth(42.0, 0.5);
        System.out.println("status=" + health.status());
    }
}
