import java.awt.Toolkit;

public class MyJVMTest_17974 {

    void waitEvents() throws InterruptedException {
        while (Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent() != null) Thread.sleep(100);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17974().waitEvents();
    }
}
