import java.util.concurrent.*;

public class MyJVMTest_5565 {

    static int a = 9;

    static int b = 6;

    static int num = 0;

    int assertEquals(int a, int b) {
        if (a != b)
            throw new RuntimeException("assert failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5565().assertEquals(a, b);
    }
}
