import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class MyJVMTest_1732 {

    static Class<? extends JTextComponent> textComponentClass = null;

    static JTextComponent textComponent = null;

    static String testString = "123 456 789";

    Class<? extends JTextComponent> initialize(Class<? extends JTextComponent> textComponentClass) {
        try {
            JFrame frame = new JFrame();
            textComponent = textComponentClass.newInstance();
            textComponent.setText(testString);
            frame.add(textComponent);
            frame.pack();
            frame.setVisible(true);
            textComponent.requestFocus();
            Caret caret = textComponent.getCaret();
            caret.setDot(textComponent.getDocument().getLength());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return textComponentClass;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1732().initialize(textComponentClass);
    }
}
