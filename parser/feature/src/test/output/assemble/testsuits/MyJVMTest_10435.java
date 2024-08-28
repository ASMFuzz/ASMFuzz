import java.util.Random;

public class MyJVMTest_10435 {

    static boolean okay = false;

    static Random r = new Random(32781);

    boolean assertTrue(boolean okay) {
        if (!okay) {
            throw new RuntimeException("Test Failed");
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10435().assertTrue(okay);
    }
}
