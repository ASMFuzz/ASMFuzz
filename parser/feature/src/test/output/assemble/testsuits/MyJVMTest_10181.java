import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_10181 {

    static String flavorParam1 = "<P9[.,<Sm=";

    static String flavorParam2 = ",VKeP>76ZM";

    static ClassLoader flavorParam3 = null;

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2, flavorParam3);

    static DataFlavor df = null;

    static Object obj = 2;

    boolean isDataFlavorSupported(DataFlavor flavor) {
        return df.equals(flavor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10181().isDataFlavorSupported(flavor));
    }
}
