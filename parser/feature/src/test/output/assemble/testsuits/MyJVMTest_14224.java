import javax.swing.*;
import javax.swing.text.html.*;

public class MyJVMTest_14224 {

    void run() {
        JTextPane htmlPane = new JTextPane();
        htmlPane.setEditorKit(new HTMLEditorKit());
        htmlPane.setText("<html><head></head><body>&#131072;</body></html>");
        String str = htmlPane.getText();
        if (str.contains("&#0;")) {
            throw new RuntimeException("Test failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14224().run();
    }
}
