import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_10919 {

    static PrinterJob myPrinterJob = null;

    static PageFormat myPageFormat = null;

    static Label pw = null, ph = null, pglm = null, pgiw = null, pgrm = null, pgtm = null, pgih = null, pgbm = null;

    static Label myWidthLabel = null;

    static Label myHeightLabel = null;

    static Label myImageableXLabel = null;

    static Label myImageableYLabel = null;

    static Label myImageableRightLabel = null;

    static Label myImageableBottomLabel = null;

    static Label myImageableWidthLabel = null;

    static Label myImageableHeightLabel = null;

    static Label myOrientationLabel = null;

    static Checkbox reverseCB = null;

    static boolean alpha = false;

    static boolean reverse = false;

    void displayPageFormatAttributes() {
        myWidthLabel.setText("Format Width = " + (float) myPageFormat.getWidth());
        myHeightLabel.setText("Format Height = " + (float) myPageFormat.getHeight());
        myImageableXLabel.setText("Format Left Margin = " + (float) myPageFormat.getImageableX());
        myImageableRightLabel.setText("Format Right Margin = " + (float) (myPageFormat.getWidth() - (myPageFormat.getImageableX() + myPageFormat.getImageableWidth())));
        myImageableWidthLabel.setText("Format ImageableWidth = " + (float) myPageFormat.getImageableWidth());
        myImageableYLabel.setText("Format Top Margin = " + (float) myPageFormat.getImageableY());
        myImageableBottomLabel.setText("Format Bottom Margin = " + (float) (myPageFormat.getHeight() - (myPageFormat.getImageableY() + myPageFormat.getImageableHeight())));
        myImageableHeightLabel.setText("Format ImageableHeight = " + (float) myPageFormat.getImageableHeight());
        int o = myPageFormat.getOrientation();
        if (o == PageFormat.LANDSCAPE && reverse) {
            o = PageFormat.REVERSE_LANDSCAPE;
            myPageFormat.setOrientation(PageFormat.REVERSE_LANDSCAPE);
        } else if (o == PageFormat.REVERSE_LANDSCAPE && !reverse) {
            o = PageFormat.LANDSCAPE;
            myPageFormat.setOrientation(PageFormat.LANDSCAPE);
        }
        myOrientationLabel.setText("Format Orientation = " + (o == PageFormat.PORTRAIT ? "PORTRAIT" : o == PageFormat.LANDSCAPE ? "LANDSCAPE" : o == PageFormat.REVERSE_LANDSCAPE ? "REVERSE_LANDSCAPE" : "<invalid>"));
        Paper p = myPageFormat.getPaper();
        pw.setText("Paper Width = " + (float) p.getWidth());
        ph.setText("Paper Height = " + (float) p.getHeight());
        pglm.setText("Paper Left Margin = " + (float) p.getImageableX());
        pgiw.setText("Paper Imageable Width = " + (float) p.getImageableWidth());
        pgrm.setText("Paper Right Margin = " + (float) (p.getWidth() - (p.getImageableX() + p.getImageableWidth())));
        pgtm.setText("Paper Top Margin = " + (float) p.getImageableY());
        pgih.setText("Paper Imageable Height = " + (float) p.getImageableHeight());
        pgbm.setText("Paper Bottom Margin = " + (float) (p.getHeight() - (p.getImageableY() + p.getImageableHeight())));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10919().displayPageFormatAttributes();
    }
}
