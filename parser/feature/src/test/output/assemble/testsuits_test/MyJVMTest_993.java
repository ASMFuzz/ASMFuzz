import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_993 {

    static Class<?> flavorParam1 = null;

    static String flavorParam2 = "Kn{hnTz3=/";

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2);

    static DataFlavor df = null;

    static Object obj = 0;

    boolean isDataFlavorSupported(DataFlavor flavor) {
        return df.equals(flavor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_993().isDataFlavorSupported(flavor));
    }
}
