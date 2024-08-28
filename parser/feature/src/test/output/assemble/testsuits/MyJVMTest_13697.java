import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_13697 {

    static Class<?> flavorParam1 = null;

    static String flavorParam2 = ":H<~2gV{LS";

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2);

    static DataFlavor m_flavor = null;

    static Object m_data = 0;

    boolean isDataFlavorSupported(DataFlavor flavor) {
        System.err.println("Have:" + flavor + " Can:" + m_flavor);
        if (flavor.equals(m_flavor))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13697().isDataFlavorSupported(flavor));
    }
}
