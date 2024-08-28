import java.awt.Toolkit;

public class MyJVMTest_8391 {

    void waitEvents() throws InterruptedException {
        while (Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent() != null) Thread.sleep(100);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8391().waitEvents();
    }
}
