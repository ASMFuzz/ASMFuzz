import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13859 {

    static JFormattedTextField ft = null;

    static String initialText = "value";

    boolean isTextEqual() throws Exception {
        final boolean[] result = new boolean[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = initialText.equals(ft.getText());
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13859().run();
    }
}
