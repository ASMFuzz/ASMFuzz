import javax.swing.*;

public class MyJVMTest_13770 {

    static JTextField textField = null;

    static JComboBox<String> comboBox = null;

    static JComboBox<String> comboBoxEd = null;

    void test() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            int expected = textField.getSize().height;
            if (comboBox.getSize().height != expected) {
                throw new RuntimeException("Wrong non-editable JComboBox height " + comboBox.getSize().height + " expected " + expected);
            }
            if (comboBoxEd.getSize().height != expected) {
                throw new RuntimeException("Wrong editable JComboBox height " + comboBoxEd.getSize().height + " expected " + expected);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13770().test();
    }
}
