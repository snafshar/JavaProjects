import java.util.Arrays;

/** Simple percentile calculation for latency samples. */
public final class LatencyPercentile {
    private LatencyPercentile() {}

    public static double percentile(double[] samples, double p) {
        if (samples == null || samples.length == 0 || p < 0 || p > 100)
            throw new IllegalArgumentException("samples must be non-empty and p must be 0..100");
        double[] values = Arrays.copyOf(samples, samples.length);
        Arrays.sort(values);
        double index = (values.length - 1) * p / 100.0;
        int lower = (int) index;
        int upper = Math.min(lower + 1, values.length - 1);
        return values[lower] + (values[upper] - values[lower]) * (index - lower);
    }
}
