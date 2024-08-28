import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.net.*;

public class MyJVMTest_15583 {

    void doSelect() throws Exception {
        Thread thread = new Thread(new CheckLocking());
        thread.start();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15583().doSelect();
    }
}
