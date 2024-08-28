import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_12015 {

    static PageFormat pf = new PageFormat();

    static double a4w = 0.7933827845177176;

    static double a4h = Double.NaN;

    double verifyPaper(PageFormat pf, double a4w, double a4h) {
        double dw1 = pf.getWidth();
        double dh1 = pf.getHeight();
        float fwMM = (float) ((dw1 * 25.4) / 72.0);
        float fhMM = (float) ((dh1 * 25.4) / 72.0);
        MediaSizeName msn = MediaSize.findMedia(fwMM, fhMM, Size2DSyntax.MM);
        System.out.println("Units = 1/72\" new size=" + dw1 + "x" + dh1);
        System.out.println("Units = MM new size=" + fwMM + "x" + fhMM);
        System.out.println("Media = " + msn);
        if (a4w != Math.rint(dw1) || a4h != Math.rint(dh1)) {
            System.out.println("Got " + Math.rint(dw1) + "x" + Math.rint(dh1) + ". Expected " + a4w + "x" + a4h);
            throw new RuntimeException("Size is not close enough to A4 size");
        }
        if (msn != MediaSizeName.ISO_A4) {
            throw new RuntimeException("MediaSizeName is not A4: " + msn);
        }
        return dw1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12015().verifyPaper(pf, a4w, a4h);
    }
}
