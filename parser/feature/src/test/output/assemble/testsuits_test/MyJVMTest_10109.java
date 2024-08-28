import java.awt.*;

public class MyJVMTest_10109 {

    void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

    static Dialog dialog = new Dialog((Frame) null);

    static Panel panel = new Panel() {

        @Override
        public boolean isValidateRoot() {
            return true;
        }
    };

    void test() {
        System.out.println("Before showing: panel.isValid=" + panel.isValid() + "      dialog.isValid=" + dialog.isValid());
        dialog.setVisible(true);
        sleep();
        System.out.println("After showing:  panel.isValid=" + panel.isValid() + "      dialog.isValid=" + dialog.isValid());
        if (!panel.isValid()) {
            dialog.dispose();
            throw new RuntimeException("The panel hasn't been validated upon showing the dialog");
        }
        dialog.setVisible(false);
        sleep();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10109().test();
    }
}
