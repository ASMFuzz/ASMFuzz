import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyJVMTest_13982 {

    static PageFormat pf = new PageFormat();

    static PrinterJob printerJob = null;

    Paper printPaperSize(PageFormat pf) {
        Paper p = pf.getPaper();
        System.out.println("paper size = (" + p.getWidth() + ", " + p.getHeight() + ")");
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13982().printPaperSize(pf);
    }
}
