import java.util.concurrent.*;

public class MyJVMTest_15001 {

    static int a = 2092952330;

    static int b = 666134715;

    static int num = 0;

    int assertEquals(int a, int b) {
        if (a != b)
            throw new RuntimeException("assert failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15001().assertEquals(a, b);
    }
}
