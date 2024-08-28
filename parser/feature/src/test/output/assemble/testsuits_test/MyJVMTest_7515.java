import java.awt.Color;

public class MyJVMTest_7515 {

    static long ms = 0;

    long delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
        return ms;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7515().delay(ms);
    }
}
