import java.io.IOException;

public class MyJVMTest_7929 {

    static int end = 898083329;

    static boolean closed = true;

    void close() {
        closed = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7929().close();
    }
}
