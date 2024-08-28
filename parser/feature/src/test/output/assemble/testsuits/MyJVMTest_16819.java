import java.awt.*;
import javax.swing.*;

public class MyJVMTest_16819 {

    static JButton button = null;

    static JToggleButton toogleButton = null;

    void checkButtonsSize() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                if (!button.getSize().equals(toogleButton.getSize())) {
                    throw new RuntimeException("Button sizes are different!");
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16819().run();
    }
}
