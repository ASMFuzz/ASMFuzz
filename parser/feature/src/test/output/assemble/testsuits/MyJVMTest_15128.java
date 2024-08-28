import javax.swing.*;

public class MyJVMTest_15128 {

    static JFrame f = null;

    void run() {
        f.getContentPane().removeAll();
        f.setVisible(false);
        f.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15128().run();
    }
}
