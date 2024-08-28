import java.awt.*;

public class MyJVMTest_13957 {

    static String fontName = "Dialog";

    static FontThread thread1 = null;

    static FontThread thread2 = null;

    static FontThread thread3 = null;

    void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13957().run();
    }
}
