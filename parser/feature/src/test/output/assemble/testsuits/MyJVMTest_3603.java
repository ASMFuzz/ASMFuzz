import java.nio.channels.*;

public class MyJVMTest_3603 {

    void test1() throws Exception {
        Selector sel = Selector.open();
        Pipe p = Pipe.open();
        p.source().configureBlocking(false);
        p.source().register(sel, SelectionKey.OP_READ);
        sel.wakeup();
        Thread.sleep(2000);
        sel.selectNow();
        long startTime = System.currentTimeMillis();
        int n = sel.select(2000);
        long endTime = System.currentTimeMillis();
        p.source().close();
        p.sink().close();
        sel.close();
        if (endTime - startTime < 1000)
            throw new RuntimeException("test failed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3603().test1();
    }
}
