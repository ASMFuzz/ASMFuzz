import javax.swing.*;
import java.awt.*;

public class MyJVMTest_806 {

    void run() {
        JOptionPane pane = new JOptionPane("Enter value", JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, null, null);
        pane.setWantsInput(true);
        JDialog dialog = pane.createDialog(null, "My Dialog");
        dialog.setVisible(true);
        Object result = pane.getValue();
        if (result == null || ((Integer) result).intValue() != JOptionPane.OK_OPTION) {
            throw new RuntimeException("Invalid result: " + result);
        }
        System.out.println("Test bug7138665 passed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_806().run();
    }
}
