import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;

public class MyJVMTest_17807 {

    static Class category = null;

    static String docflavorParam1 = "M8>$GR*SM[";

    static String docflavorParam2 = "dU7R}lKRt/";

    static DocFlavor docflavor = new DocFlavor(docflavorParam1, docflavorParam2);

    static AttributeSet attributeset = null;

    boolean isDocFlavorSupported(DocFlavor docflavor) {
        for (int i = 0; i < supportedDocFlavors.length; i++) {
            if (docflavor.equals(supportedDocFlavors[i])) {
                return true;
            }
        }
        return false;
    }

    boolean isAttributeCategorySupported(Class category) {
        if (category == null) {
            throw new NullPointerException("null category");
        }
        for (int i = 0; i < otherAttrCats.length; i++) {
            if (category == otherAttrCats[i]) {
                return true;
            }
        }
        return false;
    }

    static DocFlavor[] supportedDocFlavors = (new DocFlavor[] { javax.print.DocFlavor.INPUT_STREAM.JPEG });

    static Class[] otherAttrCats = (new Class[] { javax.print.attribute.standard.Copies.class, javax.print.attribute.standard.OrientationRequested.class, javax.print.attribute.standard.Destination.class });

    static String printer = null;

    Object getSupportedAttributeValues(Class category, DocFlavor docflavor, AttributeSet attributeset) {
        if (category == null) {
            throw new NullPointerException("null category");
        }
        if (docflavor != null) {
            if (!isDocFlavorSupported(docflavor)) {
                throw new IllegalArgumentException(docflavor + " is an unsupported flavor");
            }
        }
        if (!isAttributeCategorySupported(category)) {
            return null;
        }
        if (category == javax.print.attribute.standard.Copies.class) {
            return new CopiesSupported(1, 5);
        }
        if (category == javax.print.attribute.standard.OrientationRequested.class) {
            OrientationRequested[] req = { OrientationRequested.PORTRAIT, OrientationRequested.LANDSCAPE };
            return req;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17807().getSupportedAttributeValues(category, docflavor, attributeset));
    }
}
