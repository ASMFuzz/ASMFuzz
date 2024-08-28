import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_6675 {

    static Class[] otherAttrCats = (new Class[] { javax.print.attribute.standard.Copies.class, javax.print.attribute.standard.OrientationRequested.class, javax.print.attribute.standard.Destination.class });

    static String printer = null;

    Class[] getSupportedAttributeCategories() {
        int i = otherAttrCats.length;
        Class[] aclass = new Class[i];
        System.arraycopy(otherAttrCats, 0, aclass, 0, otherAttrCats.length);
        return aclass;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6675().getSupportedAttributeCategories()));
    }
}
