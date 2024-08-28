import javax.swing.*;
import java.awt.*;

public class MyJVMTest_17869 {

    static JMenu menu1 = null;

    static JMenu menu2 = null;

    void run() {
        Dimension popupSize1 = menu1.getPopupMenu().getSize();
        Dimension popupSize2 = menu2.getPopupMenu().getSize();
        if (popupSize1.equals(popupSize2)) {
            throw new RuntimeException("First popup unexpedetly changed its size");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17869().run();
    }
}
