import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;

public class MyJVMTest_10650 {

    static String docflavorParam1 = "Y,Ypk7,0^b";

    static String docflavorParam2 = "#R3<,=k1nq";

    static DocFlavor docflavor = new DocFlavor(docflavorParam1, docflavorParam2);

    static DocFlavor[] supportedDocFlavors = (new DocFlavor[] { javax.print.DocFlavor.INPUT_STREAM.JPEG });

    static String printer = null;

    boolean isDocFlavorSupported(DocFlavor docflavor) {
        for (int i = 0; i < supportedDocFlavors.length; i++) {
            if (docflavor.equals(supportedDocFlavors[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10650().isDocFlavorSupported(docflavor));
    }
}
