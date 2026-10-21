import java.util.Objects;

public class ValidationExamples {
    public static int parsePositiveInt(String raw) {
        Objects.requireNonNull(raw, "raw input");
        final int value;
        try {
            value = Integer.parseInt(raw.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Expected a whole number", exception);
        }
        if (value <= 0) throw new IllegalArgumentException("Value must be positive");
        return value;
    }
    public static void main(String[] args) {
        System.out.println(parsePositiveInt(args.length == 0 ? "1" : args[0]));
    }
}