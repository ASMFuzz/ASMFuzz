import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16703 {

    static JFrame frame = null;

    static JTextArea area = null;

    JFrame setup(JFrame frame) {
        area = new JTextArea();
        frame.getContentPane().add(new JScrollPane(area));
        area.setText("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        area.getCaret().setDot(area.getText().length() + 1);
        frame.setSize(300, 200);
        frame.setVisible(true);
        area.requestFocus();
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16703().setup(frame);
    }
}
