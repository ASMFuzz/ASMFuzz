import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyJVMTest_11084 {

    void printPaperSize(PageFormat pf) {
        Paper p = pf.getPaper();
        System.out.println("paper size = (" + p.getWidth() + ", " + p.getHeight() + ")");
    }

    static boolean VALIDATE = true;

    static PrinterJob printerJob = null;

    static PageFormat pageFormat = null;

    void print() {
        {
            try {
                if (VALIDATE) {
                    this.pageFormat = printerJob.validatePage(this.pageFormat);
                }
                printPaperSize(pageFormat);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11084().print();
    }
}
