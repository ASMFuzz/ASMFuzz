import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.awt.print.*;

public class MyJVMTest_6241 {

    static String flavorParam1 = "=*Rdb:7+~&";

    static String flavorParam2 = "ui;)oWR.<%";

    static DocFlavor flavor = new DocFlavor(flavorParam1, flavorParam2);

    boolean isDocFlavorSupported(DocFlavor flavor) {
        if (DocFlavor.SERVICE_FORMATTED.PAGEABLE.equals(flavor))
            return true;
        if (DocFlavor.SERVICE_FORMATTED.PRINTABLE.equals(flavor))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6241().isDocFlavorSupported(flavor));
    }
}
