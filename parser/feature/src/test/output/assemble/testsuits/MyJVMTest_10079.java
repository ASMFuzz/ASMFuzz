import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.*;
import java.io.*;

public class MyJVMTest_10079 {

    static Button print2D = new Button("2D Print");

    static Button printMerlin = new Button("PrintService");

    static PrinterJob pj = PrinterJob.getPrinterJob();

    static PrintService defService = null;

    static HashPrintRequestAttributeSet prSet = new HashPrintRequestAttributeSet();

    DocFlavor getDocFlavor() {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        return flavor;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10079().getDocFlavor());
    }
}
