import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5680 {

    static JFrame frame = null;

    static JTextArea area = null;

    void run() {
        int width = area.getWidth();
        double caretX = area.getCaret().getMagicCaretPosition().getX();
        if (width < caretX + 1) {
            throw new RuntimeException("Width of the area (" + width + ") is less than caret x-position " + caretX + 1);
        }
        area.putClientProperty("caretWidth", 10);
        frame.pack();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5680().run();
    }
}
