import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_17025 {

    static String dfParam1 = "wGMONYr<H]";

    static DataFlavor df = new DataFlavor(dfParam1);

    static DataFlavor dataFlavor = null;

    static Object data = new Object();

    boolean isDataFlavorSupported(DataFlavor df) {
        return dataFlavor.equals(df);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17025().isDataFlavorSupported(df));
    }
}
