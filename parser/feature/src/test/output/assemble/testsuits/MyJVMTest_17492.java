import java.io.IOException;

public class MyJVMTest_17492 {

    static int end = 0;

    static boolean closed = true;

    void close() {
        closed = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17492().close();
    }
}
