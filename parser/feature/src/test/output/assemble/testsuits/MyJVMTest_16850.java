import java.security.*;
import java.rmi.server.RemoteServer;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_16850 {

    Object run() {
        try {
            System.err.println("Attempt to set log without permission");
            RemoteServer.setLog(new ByteArrayOutputStream());
            throw new RuntimeException("TEST FAILED: set log without permission");
        } catch (SecurityException e) {
            System.err.println("TEST PASSED: unable to set log without permission");
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16850().run());
    }
}
