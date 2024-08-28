import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;

public class MyJVMTest_17700 {

    static Class category = null;

    static Class[] otherAttrCats = (new Class[] { javax.print.attribute.standard.Copies.class, javax.print.attribute.standard.OrientationRequested.class, javax.print.attribute.standard.Destination.class });

    static String printer = null;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17700().isAttributeCategorySupported(category));
    }
}
