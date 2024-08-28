import javax.swing.*;

public class MyJVMTest_227 {

    void run() {
        GroupLayout groupLayout = new GroupLayout(new JPanel());
        try {
            groupLayout.createParallelGroup(null);
            throw new RuntimeException("groupLayout.createParallelGroup(null) doesn't throw IAE");
        } catch (IllegalArgumentException e) {
        }
        try {
            groupLayout.createParallelGroup(null, true);
            throw new RuntimeException("groupLayout.createParallelGroup(null, true) doesn't throw IAE");
        } catch (IllegalArgumentException e) {
        }
        try {
            groupLayout.createParallelGroup(null, false);
            throw new RuntimeException("groupLayout.createParallelGroup(null, false) doesn't throw IAE");
        } catch (IllegalArgumentException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_227().run();
    }
}
