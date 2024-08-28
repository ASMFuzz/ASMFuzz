import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_8485 {

    static String connectStr = "6W,iiY>LlT";

    static ServerSocket ss = null;

    static InetAddress serverInetAddr = null;

    static int serverPort = 0;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static boolean delayedWrite = false;

    int retrieveConnectInfo(String connectStr) throws Exception {
        int starti;
        int endi;
        String connectInfo;
        String serverName = null;
        try {
            starti = connectStr.indexOf(' ');
            endi = connectStr.lastIndexOf(' ');
            connectInfo = connectStr.substring(starti + 1, endi).trim();
            endi = connectInfo.indexOf(':');
            serverName = connectInfo.substring(0, endi);
            serverPort = Integer.parseInt(connectInfo.substring(endi + 1));
        } catch (Exception e) {
            throw new IOException("Proxy recieved a request: " + connectStr);
        }
        serverInetAddr = InetAddress.getByName(serverName);
        return endi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8485().retrieveConnectInfo(connectStr);
    }
}
