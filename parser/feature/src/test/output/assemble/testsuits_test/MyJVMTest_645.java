import javax.swing.*;
import javax.swing.plaf.basic.*;

public class MyJVMTest_645 {

    void run() {
        JComboBox comboBox = new JComboBox();
        comboBox.setUI(new bug6337518());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_645().run();
    }
}
