import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9662 {

    static JFrame frame = null;

    static JTextPane jTextPane = null;

    void run() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        jTextPane = new JTextPane();
        jTextPane.setContentType("text/html");
        jTextPane.setText("<html><body><b id='test'>Test Test Test Test Test Test " + "Test Test Test Test Test Test Test Test Test Test " + "Test Test Test Test Test Test Test Test Test Test" + "</b></body></html>");
        frame.getContentPane().add(jTextPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9662().run();
    }
}
