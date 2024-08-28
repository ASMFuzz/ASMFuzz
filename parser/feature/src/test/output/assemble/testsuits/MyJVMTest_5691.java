import javax.swing.*;

public class MyJVMTest_5691 {

    static JFrame f = null;

    void run() {
        f.getContentPane().removeAll();
        f.setVisible(false);
        f.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5691().run();
    }
}
