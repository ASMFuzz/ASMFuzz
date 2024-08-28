import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_13485 {

    static double yCaret = Double.NEGATIVE_INFINITY;

    static double xCaret = Double.MIN_VALUE;

    static JEditorPane edit = new JEditorPane();

    static TableViewLayoutTest frame = null;

    void run() {
        frame = new TableViewLayoutTest();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13485().run();
    }
}
