import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;

public class MyJVMTest_1262 {

    static double PIXELS_PER_INCH = 72.0;

    static PrinterJob printerJob = null;

    static PageFormat pageFormat = null;

    void createPageFormat() {
        pageFormat = new PageFormat();
        Paper p = new Paper();
        double width = 12.0 * PIXELS_PER_INCH;
        double height = 14.0 * PIXELS_PER_INCH;
        double ix = PIXELS_PER_INCH;
        double iy = PIXELS_PER_INCH;
        double iwidth = width - 2.0 * PIXELS_PER_INCH;
        double iheight = height - 2.0 * PIXELS_PER_INCH;
        p.setSize(width, height);
        p.setImageableArea(ix, iy, iwidth, iheight);
        pageFormat.setPaper(p);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1262().createPageFormat();
    }
}
