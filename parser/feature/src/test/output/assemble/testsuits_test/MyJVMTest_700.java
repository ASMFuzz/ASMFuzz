import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_700 {

    static Dialog dialog = new Dialog((Window) null, "Test Dialog", Dialog.ModalityType.TOOLKIT_MODAL);

    void run() {
        dialog.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_700().run();
    }
}
