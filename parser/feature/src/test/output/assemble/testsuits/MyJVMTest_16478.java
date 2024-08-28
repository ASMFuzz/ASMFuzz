import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16478 {

    static JComboBox comboBox = null;

    int getSelectedIndex() throws Exception {
        final int[] result = new int[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = comboBox.getSelectedIndex();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16478().run();
    }
}
