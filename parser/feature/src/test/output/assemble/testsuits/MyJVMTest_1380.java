import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_1380 {

    static DataFlavor df = null;

    static Object obj = 8;

    DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { df };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1380().getTransferDataFlavors()));
    }
}
