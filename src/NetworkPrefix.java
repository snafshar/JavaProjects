import java.util.Objects;

/** Value object for a CIDR prefix used by networking examples. */
public final class NetworkPrefix {
    private final String address;
    private final int prefixLength;

    public NetworkPrefix(String address, int prefixLength) {
        if (address == null || address.isBlank()) throw new IllegalArgumentException("address is required");
        if (prefixLength < 0 || prefixLength > 32) throw new IllegalArgumentException("prefix must be 0..32");
        this.address = address;
        this.prefixLength = prefixLength;
    }

    public String address() { return address; }
    public int prefixLength() { return prefixLength; }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof NetworkPrefix that)) return false;
        return prefixLength == that.prefixLength && address.equals(that.address);
    }

    @Override public int hashCode() { return Objects.hash(address, prefixLength); }
    @Override public String toString() { return address + "/" + prefixLength; }
}
