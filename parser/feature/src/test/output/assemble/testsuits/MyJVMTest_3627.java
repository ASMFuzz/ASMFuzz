import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_3627 {

    static String flavorParam1 = "_78Le=w}2B";

    static String flavorParam2 = "Hjtfw.S}v(";

    static ClassLoader flavorParam3 = null;

    static DataFlavor flavor = new DataFlavor(flavorParam1, flavorParam2, flavorParam3);

    static DataFlavor m_flavor = null;

    static Object m_data = 7;

    Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(m_flavor)) {
            return (Object) m_data;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3627().getTransferData(flavor));
    }
}
