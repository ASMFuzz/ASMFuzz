import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_1691 {

    static int port = 1;

    int checkListen(int port) {
        throw new SecurityException("THOU SHALT NOT LISTEN");
        return port;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1691().checkListen(port);
    }
}
