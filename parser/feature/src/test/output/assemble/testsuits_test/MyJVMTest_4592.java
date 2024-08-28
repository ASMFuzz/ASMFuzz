import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyJVMTest_4592 {

    static PageFormat pf = new PageFormat();

    static PrinterJob printerJob = null;

    Paper printPaperSize(PageFormat pf) {
        Paper p = pf.getPaper();
        System.out.println("paper size = (" + p.getWidth() + ", " + p.getHeight() + ")");
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4592().printPaperSize(pf);
    }
}
