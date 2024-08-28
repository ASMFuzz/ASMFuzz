import javax.swing.*;
import java.awt.*;

public class MyJVMTest_10223 {

    static JFrame frame = null;

    static Point location = null;

    static Point iconloc = null;

    static JInternalFrame jif = null;

    void check2() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            iconloc = jif.getDesktopIcon().getLocation();
        });
        if (iconloc.equals(location)) {
            System.out.println("Second test passed");
        } else {
            throw new RuntimeException("Icon isn't located near the frame bottom");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10223().check2();
    }
}
