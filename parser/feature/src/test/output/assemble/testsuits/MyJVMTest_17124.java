import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;
import javax.management.Attribute;

public class MyJVMTest_17124 {

    static String attrvalParam1 = "LBSfpW`;(8";

    static Object attrvalParam2 = 0;

    static Attribute attrval = new Attribute(attrvalParam1, attrvalParam2);

    static String flavorParam1 = "O.Gq\"H|&!2";

    static String flavorParam2 = "g}F,}@2!~g";

    static DocFlavor flavor = new DocFlavor(flavorParam1, flavorParam2);

    static AttributeSet attributes = null;

    static String printer = null;

    boolean isAttributeValueSupported(Attribute attrval, DocFlavor flavor, AttributeSet attributes) {
        if (attrval == OrientationRequested.PORTRAIT)
            return true;
        else if (attrval == OrientationRequested.LANDSCAPE)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17124().isAttributeValueSupported(attrval, flavor, attributes));
    }
}
