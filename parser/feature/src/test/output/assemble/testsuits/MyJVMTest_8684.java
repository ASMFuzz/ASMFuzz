import java.io.IOException;

public class MyJVMTest_8684 {

    static int end = 5;

    static boolean closed = true;

    void close() {
        closed = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8684().close();
    }
}
