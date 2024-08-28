import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_4124 {

    static double yCaret = Double.MAX_VALUE;

    static double xCaret = 0d;

    static JEditorPane edit = new JEditorPane();

    static TableViewLayoutTest frame = null;

    void run() {
        frame = new TableViewLayoutTest();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4124().run();
    }
}
