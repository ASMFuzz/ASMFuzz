import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13688 {

    static JFrame frame = null;

    static Point location = null;

    static Point iconloc = null;

    static JInternalFrame jif = null;

    void check1() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            iconloc = jif.getDesktopIcon().getLocation();
        });
        if (!iconloc.equals(location)) {
            System.out.println("First test passed");
        } else {
            throw new RuntimeException("Icon isn't shifted with the frame bounds");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13688().check1();
    }
}
