import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class MyJVMTest_13407 {

    static JTextComponent textComponent = null;

    String getText() throws Exception {
        final String[] result = new String[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = textComponent.getText();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13407().run();
    }
}
