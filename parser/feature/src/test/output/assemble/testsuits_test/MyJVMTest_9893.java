import java.net.*;

public class MyJVMTest_9893 {

    static ServerSocket svr = null;

    int getPort() {
        return svr.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9893().getPort());
    }
}
