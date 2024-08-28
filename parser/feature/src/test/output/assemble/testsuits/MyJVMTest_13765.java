import javax.swing.*;

public class MyJVMTest_13765 {

    static int level = 3;

    void run() {
        SwingWorker<String, Void> sw = new NestedWorkers(0);
        sw.execute();
        try {
            System.err.println(sw.get());
        } catch (Exception z) {
            throw new RuntimeException(z);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13765().run();
    }
}
