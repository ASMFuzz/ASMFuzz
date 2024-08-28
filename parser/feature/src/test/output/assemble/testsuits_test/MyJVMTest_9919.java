import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_9919 {

    static String msg = "FkrY:L9w6#";

    static CountDownLatch done = new CountDownLatch(1);

    static AtomicBoolean failed = new AtomicBoolean(false);

    String fail(String msg) {
        failed.set(true);
        done.countDown();
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9919().fail(msg);
    }
}
