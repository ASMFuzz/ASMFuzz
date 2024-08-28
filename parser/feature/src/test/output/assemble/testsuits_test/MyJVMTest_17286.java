import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_17286 {

    static Component titleComponent = null;

    static JLayeredPane lPane = null;

    static boolean titleFound = false;

    void setTitleComponentEDT() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < lPane.getComponentsInLayer(JLayeredPane.FRAME_CONTENT_LAYER.intValue()).length; j++) {
                    titleComponent = lPane.getComponentsInLayer(JLayeredPane.FRAME_CONTENT_LAYER.intValue())[j];
                    if (titleComponent.getClass().getName().equals("javax.swing.plaf.metal.MetalTitlePane")) {
                        titleFound = true;
                        break;
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17286().run();
    }
}
