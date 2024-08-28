import java.util.Random;

public class MyJVMTest_8688 {

    static boolean okay = true;

    static Random r = new Random(32781);

    boolean assertTrue(boolean okay) {
        if (!okay) {
            throw new RuntimeException("Test Failed");
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8688().assertTrue(okay);
    }
}
