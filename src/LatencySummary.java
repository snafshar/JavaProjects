public final class LatencySummary {
    private LatencySummary() {}
    public static double average(double[] samples) {
        if (samples.length == 0) throw new IllegalArgumentException("samples cannot be empty");
        double sum = 0;
        for (double sample : samples) sum += sample;
        return sum / samples.length;
    }
    public static double minimum(double[] samples) {
        if (samples.length == 0) throw new IllegalArgumentException("samples cannot be empty");
        double min = samples[0];
        for (double sample : samples) min = Math.min(min, sample);
        return min;
    }
}
