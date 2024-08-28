import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_11994 {

    static DataFlavor flavor = new DataFlavor();

    static DataFlavor df = null;

    static Object obj = 6;

    Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (df.equals(flavor)) {
            return obj;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11994().getTransferData(flavor));
    }
}
