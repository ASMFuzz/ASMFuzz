import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_18056 {

    static Robot r = null;

    static JButton bn1 = null;

    static JButton bs1 = null;

    static JButton bn2 = null;

    static JButton bs2 = null;

    static Point bn1Loc = null;

    static Point bs1Loc = null;

    static Point bn2Loc = null;

    static Point bs2Loc = null;

    void getLocations() {
        bn1Loc = bn1.getLocationOnScreen();
        bn1Loc.translate(bn1.getWidth() / 2, bn1.getHeight() / 2);
        bn2Loc = bn2.getLocationOnScreen();
        bn2Loc.translate(bn2.getWidth() / 2, bn2.getHeight() / 2);
        bs1Loc = bs1.getLocationOnScreen();
        bs1Loc.translate(bs1.getWidth() / 2, bs1.getHeight() / 2);
        bs2Loc = bs2.getLocationOnScreen();
        bs2Loc.translate(bs2.getWidth() / 2, bs2.getHeight() / 2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18056().getLocations();
    }
}
