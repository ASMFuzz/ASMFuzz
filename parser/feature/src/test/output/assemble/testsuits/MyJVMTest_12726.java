import java.net.*;
import java.io.*;
import java.lang.reflect.Proxy;

public class MyJVMTest_12726 {

    static InvocationHandler socketParam1Param1 = null;

    static Proxy socketParam1 = new Proxy(socketParam1Param1);

    static Socket socket = new Socket(socketParam1);

    static int failCount = 5;

    Socket test(Socket socket) throws IOException {
        int socketPort = socket.getPort();
        InetAddress socketInetAddress = socket.getInetAddress();
        SocketAddress socketRemoteSocketAddress = socket.getRemoteSocketAddress();
        int socketLocalPort = socket.getLocalPort();
        socket.close();
        if (socketPort != socket.getPort()) {
            System.out.println("Socket.getPort failed");
            failCount++;
        }
        if (!socket.getInetAddress().equals(socketInetAddress)) {
            System.out.println("Socket.getInetAddress failed");
            failCount++;
        }
        if (!socket.getRemoteSocketAddress().equals(socketRemoteSocketAddress)) {
            System.out.println("Socket.getRemoteSocketAddresss failed");
            failCount++;
        }
        if (socketLocalPort != socket.getLocalPort()) {
            System.out.println("Socket.getLocalPort failed");
            failCount++;
        }
        InetAddress anyAddr = null;
        try {
            anyAddr = InetAddress.getByAddress("", new byte[] { 0, 0, 0, 0 });
        } catch (UnknownHostException uhe) {
        }
        if (anyAddr != null && !socket.getLocalAddress().equals(anyAddr)) {
            System.out.println("Socket.getLocalAddress failed");
            failCount++;
        }
        InetSocketAddress addr = new InetSocketAddress(socket.getLocalPort());
        if (!socket.getLocalSocketAddress().equals(addr)) {
            System.out.println("Socket.getLocalSocketAddress failed");
            failCount++;
        }
        if (!socket.isConnected()) {
            System.out.println("Socket.isConnected failed");
            failCount++;
        }
        if (!socket.isBound()) {
            System.out.println("Socket.isBound failed");
            failCount++;
        }
        return socket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12726().test(socket);
    }
}
