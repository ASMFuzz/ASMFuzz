import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;

public class MyJVMTest_13108 {

    static Class category = null;

    static String printer = null;

    Object getDefaultAttributeValue(Class category) {
        if (category == null) {
            throw new NullPointerException("null category");
        }
        if (category == javax.print.attribute.standard.Copies.class)
            return new Copies(1);
        if (category == javax.print.attribute.standard.OrientationRequested.class)
            return OrientationRequested.PORTRAIT;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13108().getDefaultAttributeValue(category));
    }
}
