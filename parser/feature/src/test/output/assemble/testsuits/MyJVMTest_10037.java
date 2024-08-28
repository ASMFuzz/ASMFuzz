import java.net.*;

public class MyJVMTest_10037 {

    static ServerSocket ss = null;

    int localPort() {
        return ss.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10037().localPort());
    }
}
