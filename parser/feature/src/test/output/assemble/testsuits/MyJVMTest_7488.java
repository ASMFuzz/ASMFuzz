import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_7488 {

    static String dfParam1 = "6?)VZ40Gf7";

    static String dfParam2 = "1vn5w3+\\\".";

    static ClassLoader dfParam3 = null;

    static DataFlavor df = new DataFlavor(dfParam1, dfParam2, dfParam3);

    static DataFlavor dataFlavor = null;

    static Object data = new Object();

    boolean isDataFlavorSupported(DataFlavor df) {
        return dataFlavor.equals(df);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7488().isDataFlavorSupported(df));
    }
}
