import java.awt.Color;

public class MyJVMTest_17054 {

    static long ms = 0;

    long delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
        return ms;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17054().delay(ms);
    }
}
