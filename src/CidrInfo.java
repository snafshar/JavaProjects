import java.net.InetAddress;

public final class CidrInfo {
    private CidrInfo() {}

    public static void main(String[] args) throws Exception {
        String address = args.length == 0 ? "192.168.1.1" : args[0];
        InetAddress ip = InetAddress.getByName(address);
        System.out.println("Host: " + ip.getHostName());
        System.out.println("Address: " + ip.getHostAddress());
        System.out.println("Loopback: " + ip.isLoopbackAddress());
        System.out.println("Private/local: " + ip.isSiteLocalAddress());
    }
}
