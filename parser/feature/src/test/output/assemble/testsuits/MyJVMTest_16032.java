import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_16032 {

    static int oParam1 = 551;

    static OrientationRequested o = new OrientationRequested(oParam1);

    PrintRequestAttributeSet doit(OrientationRequested o) throws Exception {
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.getPrintService() == null) {
            System.out.println("No print service found.");
            return;
        }
        pj.setPrintable(new DeviceScale());
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(o);
        String fileName = "out.prn";
        File f = new File(fileName);
        f.deleteOnExit();
        URI dest = f.toURI();
        aset.add(new Destination(dest));
        pj.print(aset);
        return aset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16032().doit(o);
    }
}
