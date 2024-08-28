import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_12490 {

    static DataFlavor m_flavor = null;

    static Object m_data = 9;

    DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { m_flavor };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12490().getTransferDataFlavors()));
    }
}
