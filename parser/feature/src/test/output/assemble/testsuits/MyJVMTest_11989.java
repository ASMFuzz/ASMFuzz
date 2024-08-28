import java.util.concurrent.Callable;

public class MyJVMTest_11989 {

    static Callable<Object> test = null;

    static int ITERS = Integer.getInteger("iters", 1);

    static Object sink = 0;

    Callable<Object> testNPE(Callable<Object> test) throws Exception {
        for (int c = 0; c < ITERS; c++) {
            try {
                sink = test.call();
                throw new IllegalStateException("Expected NPE");
            } catch (NullPointerException iae) {
            }
        }
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11989().testNPE(test);
    }
}
