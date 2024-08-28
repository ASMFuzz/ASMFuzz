import java.awt.*;
import javax.swing.*;

public class MyJVMTest_3776 {

    static JButton button = null;

    static JToggleButton toogleButton = null;

    void run() {
        if (!button.getSize().equals(toogleButton.getSize())) {
            throw new RuntimeException("Button sizes are different!");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3776().run();
    }
}
