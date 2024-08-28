import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_12963 {

    static DataFlavor flavor = new DataFlavor();

    static DataFlavor m_flavor = null;

    static Object m_data = 8;

    Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(m_flavor)) {
            return (Object) m_data;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12963().getTransferData(flavor));
    }
}
