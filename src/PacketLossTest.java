/** Lightweight executable checks for PacketLoss; run with assertions enabled. */
public final class PacketLossTest {
    public static void main(String[] args) {
        assert PacketLoss.percent(10, 10) == 0.0;
        assert PacketLoss.percent(10, 0) == 100.0;
        assert PacketLoss.percent(0, 0) == 0.0;
        boolean rejected = false;
        try { PacketLoss.percent(2, 3); }
        catch (IllegalArgumentException expected) { rejected = true; }
        assert rejected;
        System.out.println("PacketLoss checks passed");
    }
}
