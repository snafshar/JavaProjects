import java.net.InetAddress;

public final class NetworkAddress {
    private NetworkAddress() {}
    public static String resolve(String host) throws Exception {
        return InetAddress.getByName(host).getHostAddress();
    }
    public static void main(String[] args) throws Exception {
        String host = args.length == 0 ? "localhost" : args[0];
        System.out.println(host + " -> " + resolve(host));
    }
}
