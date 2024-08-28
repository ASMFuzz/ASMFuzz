import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyJVMTest_17611 {

    static double PIXELS_PER_INCH = 72.0;

    static double WIDTH = 17.0;

    static double LENGTH = 24.0;

    static PrinterJob printerJob = null;

    static PageFormat pageFormat = null;

    void createPageFormat() {
        pageFormat = new PageFormat();
        Paper p = new Paper();
        double width = WIDTH * PIXELS_PER_INCH;
        double height = LENGTH * PIXELS_PER_INCH;
        double ix = PIXELS_PER_INCH;
        double iy = PIXELS_PER_INCH;
        double iwidth = width - 2.0 * PIXELS_PER_INCH;
        double iheight = height - 2.0 * PIXELS_PER_INCH;
        p.setSize(width, height);
        p.setImageableArea(ix, iy, iwidth, iheight);
        pageFormat.setPaper(p);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17611().createPageFormat();
    }
}
