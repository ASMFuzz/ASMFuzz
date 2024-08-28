import javax.swing.*;
import javax.swing.plaf.basic.*;

public class MyJVMTest_9815 {

    void run() {
        JComboBox comboBox = new JComboBox();
        comboBox.setUI(new bug6337518());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9815().run();
    }
}
