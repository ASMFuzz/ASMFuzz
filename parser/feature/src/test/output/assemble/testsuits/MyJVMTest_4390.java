import javax.swing.*;

public class MyJVMTest_4390 {

    static int level = 1;

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
        new MyJVMTest_4390().run();
    }
}
