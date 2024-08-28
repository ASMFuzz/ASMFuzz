import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_12090 {

    static double d = Double.NaN;

    static PrinterJob myPrinterJob = null;

    static PageFormat myPageFormat = null;

    static Label pw = null, ph = null, pglm = null, pgrm = null, pgiw = null, pgih = null, pgtm = null, pgbm = null;

    static TextField tpw = null, tph = null, tpglm = null, tpgtm = null, tpgiw = null, tpgih = null;

    static Label myWidthLabel = null;

    static Label myHeightLabel = null;

    static Label myImageableXLabel = null;

    static Label myImageableYLabel = null;

    static Label myImageableRightLabel = null;

    static Label myImageableBottomLabel = null;

    static Label myImageableWidthLabel = null;

    static Label myImageableHeightLabel = null;

    static Label myOrientationLabel = null;

    String drnd(double d) {
        d = d * 10.0 + 0.5;
        d = Math.floor(d) / 10.0;
        String ds = Double.toString(d);
        int decimal_pos = ds.indexOf(".");
        int len = ds.length();
        if (len > decimal_pos + 2) {
            return ds.substring(0, decimal_pos + 2);
        } else {
            return ds;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12090().drnd(d));
    }
}
