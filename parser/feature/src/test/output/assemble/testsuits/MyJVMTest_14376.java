import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Handler;

public class MyJVMTest_14376 {

    static boolean closed = false;

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
        new MyJVMTest_14376().close();
    }
}
