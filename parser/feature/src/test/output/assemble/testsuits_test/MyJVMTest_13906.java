import java.nio.channels.*;

public class MyJVMTest_13906 {

    void test2() throws Exception {
        Selector sel = Selector.open();
        Pipe p = Pipe.open();
        p.source().configureBlocking(false);
        sel.wakeup();
        Thread.sleep(2000);
        sel.selectNow();
        long startTime = System.currentTimeMillis();
        int n = sel.select(2000);
        long endTime = System.currentTimeMillis();
        sel.close();
        if (endTime - startTime < 1000)
            throw new RuntimeException("test failed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13906().test2();
    }
}
