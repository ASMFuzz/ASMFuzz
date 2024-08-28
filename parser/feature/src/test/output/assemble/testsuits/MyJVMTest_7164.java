import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7164 {

    static JTextArea area = null;

    void run() {
        int width = area.getWidth();
        double caretX = area.getCaret().getMagicCaretPosition().getX();
        if (width < caretX + 10) {
            throw new RuntimeException("Width of the area (" + width + ") is less  than caret x-position " + caretX + 10);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7164().run();
    }
}
