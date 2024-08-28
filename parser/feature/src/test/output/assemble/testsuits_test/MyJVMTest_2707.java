import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_2707 {

    static String flavorParam1 = "qg~2&[a$)v";

    static String flavorParam2 = ":ol@T:jVIq";

    static ClassLoader flavorParam3 = null;

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2, flavorParam3);

    static DataFlavor df = null;

    static Object obj = 756004500;

    Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (df.equals(flavor)) {
            return obj;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2707().getTransferData(flavor));
    }
}
