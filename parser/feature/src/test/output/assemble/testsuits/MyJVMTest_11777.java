import java.util.concurrent.Callable;

public class MyJVMTest_11777 {

    static boolean expected = true;

    static Callable<Object> test = null;

    static int ITERS = Integer.getInteger("iters", 1);

    boolean testOK(boolean expected, Callable<Object> test) throws Exception {
        for (int c = 0; c < ITERS; c++) {
            Object res = test.call();
            if (!res.equals(expected)) {
                throw new IllegalStateException("Wrong result: expected = " + expected + ", but got " + res);
            }
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11777().testOK(expected, test);
    }
}
