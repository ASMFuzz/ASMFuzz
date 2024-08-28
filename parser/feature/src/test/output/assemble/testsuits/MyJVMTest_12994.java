import javax.swing.*;
import java.awt.Dimension;

public class MyJVMTest_12994 {

    void run() {
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");
        jep.setEditable(false);
        jep.setText("<HTML><BODY><HR size='5px'></BODY></HTML>");
        jep.setPreferredSize(new Dimension(640, 480));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12994().run();
    }
}
