import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11947 {

    static JEditorPane jep = null;

    String getPageAnchor() throws Exception {
        final String[] result = new String[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = jep.getPage().getRef();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11947().run();
    }
}
