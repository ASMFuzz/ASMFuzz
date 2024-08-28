import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_10368 {

    static DataFlavor dataFlavor = null;

    static Object data = new Object();

    DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { dataFlavor };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10368().getTransferDataFlavors()));
    }
}
