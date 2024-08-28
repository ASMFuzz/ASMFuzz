import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15751 {

    static Component mweParam1 = new Container();

    static int mweParam2 = 761;

    static long mweParam3 = -4617317253185642890L;

    static int mweParam4 = 920;

    static int mweParam5 = 647;

    static int mweParam6 = 700;

    static int mweParam7 = 992;

    static int mweParam8 = 423;

    static int mweParam9 = 273;

    static boolean mweParam10 = false;

    static int mweParam11 = 806;

    static int mweParam12 = 617;

    static int mweParam13 = 247;

    static MouseWheelEvent mwe = new MouseWheelEvent(mweParam1, mweParam2, mweParam3, mweParam4, mweParam5, mweParam6, mweParam7, mweParam8, mweParam9, mweParam10, mweParam11, mweParam12, mweParam13);

    static Scrollbar sb1 = null;

    static Scrollbar sb2 = null;

    static Panel pnl = null;

    static int sb1upevents = 7, sb2upevents = 1327591627, pnlupevents = 1;

    static int sb1downevents = 9, sb2downevents = 8, pnldownevents = 533517077;

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
        new MyJVMTest_15751().mouseWheelMoved(mwe);
    }
}
