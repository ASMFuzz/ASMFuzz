import javax.swing.*;
import java.awt.*;

public class MyJVMTest_17579 {

    static JToolBar jToolBar1 = null;

    void makeToolbarFloat() {
        javax.swing.plaf.basic.BasicToolBarUI ui = (javax.swing.plaf.basic.BasicToolBarUI) jToolBar1.getUI();
        if (!ui.isFloating()) {
            ui.setFloatingLocation(100, 100);
            ui.setFloating(true, jToolBar1.getLocation());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17579().makeToolbarFloat();
    }
}
