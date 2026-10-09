public final class NetworkStatisticsDemo {
    private NetworkStatisticsDemo() {}

    public static void main(String[] args) {
        int sent = 250;
        int received = 244;
        double loss = NetworkStatistics.packetLossPercent(sent, received);
        System.out.printf("Sent: %d%nReceived: %d%nPacket loss: %.2f%%%n",
                sent, received, loss);
    }
}
