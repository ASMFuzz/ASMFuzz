import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_2184 {

    static ServerSocket proxySocket = null;

    SocketAddress getAddress() {
        return proxySocket.getLocalSocketAddress();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2184().getAddress());
    }
}
