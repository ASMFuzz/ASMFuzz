import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Handler;

public class MyJVMTest_4970 {

    static boolean closed = true;

    static CopyOnWriteArrayList<Handler> INSTANCES = new CopyOnWriteArrayList<>();

    void close() throws SecurityException {
        closed = true;
        try {
            System.out.println(INSTANCES);
        } catch (Throwable t) {
        }
        throw new LinkageError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4970().close();
    }
}
