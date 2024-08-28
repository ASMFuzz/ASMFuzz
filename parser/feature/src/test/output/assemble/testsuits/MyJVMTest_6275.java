import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6275 {

    static Component mweParam1 = new Container();

    static int mweParam2 = 275;

    static long mweParam3 = 0;

    static int mweParam4 = 940;

    static int mweParam5 = 619;

    static int mweParam6 = 622;

    static int mweParam7 = 719;

    static int mweParam8 = 431;

    static int mweParam9 = 647;

    static boolean mweParam10 = true;

    static int mweParam11 = 273;

    static int mweParam12 = 568;

    static int mweParam13 = 978;

    static double mweParam14 = Double.NaN;

    static MouseWheelEvent mwe = new MouseWheelEvent(mweParam1, mweParam2, mweParam3, mweParam4, mweParam5, mweParam6, mweParam7, mweParam8, mweParam9, mweParam10, mweParam11, mweParam12, mweParam13, mweParam14);

    static Scrollbar sb1 = null;

    static Scrollbar sb2 = null;

    static Panel pnl = null;

    static int sb1upevents = 0, sb2upevents = 5, pnlupevents = 381282096;

    static int sb1downevents = 0, sb2downevents = 0, pnldownevents = 4;

    Component mouseWheelMoved(MouseWheelEvent mwe) {
        Component src = mwe.getComponent();
        System.out.println("mouseWheelMoved() on " + src.getName());
        if (mwe.getWheelRotation() == -1) {
            if (src == sb1) {
                sb1upevents++;
            } else if (src == sb2) {
                sb2upevents++;
            } else if (src == pnl) {
                pnlupevents++;
            } else {
                System.out.println("weird source component");
            }
        } else if (mwe.getWheelRotation() == 1) {
            if (src == sb1) {
                sb1downevents++;
            } else if (src == sb2) {
                sb2downevents++;
            } else if (src == pnl) {
                pnldownevents++;
            } else {
                System.out.println("weird source component");
            }
        } else {
            System.out.println("weird wheel rotation");
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6275().mouseWheelMoved(mwe);
    }
}
