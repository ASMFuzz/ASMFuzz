import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_17510 {

    static String dfParam1 = "Mqu.J7%B96";

    static DataFlavor df = new DataFlavor(dfParam1);

    boolean isDataFlavorSupported(DataFlavor df) {
        return dataFlavor.equals(df);
    }

    static DataFlavor dataFlavor = null;

    static Object data = new Object();

    Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(df)) {
            throw new UnsupportedFlavorException(df);
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17510().getTransferData(df));
    }
}
