import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_4323 {

    static String flavorParam1 = "@{Yl>.WWPW";

    static String flavorParam2 = "UeeeG1QvKd";

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2);

    static DataFlavor m_flavor = null;

    static Object m_data = 6;

    boolean isDataFlavorSupported(DataFlavor flavor) {
        System.err.println("Have:" + flavor + " Can:" + m_flavor);
        if (flavor.equals(m_flavor))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4323().isDataFlavorSupported(flavor));
    }
}
