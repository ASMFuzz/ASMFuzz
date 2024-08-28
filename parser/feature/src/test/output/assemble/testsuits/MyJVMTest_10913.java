import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_10913 {

    static int port = -455575285;

    int checkListen(int port) {
        throw new SecurityException("THOU SHALT NOT LISTEN");
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10913().checkListen(port);
    }
}
