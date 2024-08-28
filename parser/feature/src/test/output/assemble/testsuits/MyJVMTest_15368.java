import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

public class MyJVMTest_15368 {

    static String flavorParam1 = "OH#P vsc}T";

    static DataFlavor flavor = new DataFlavor(flavorParam1);

    boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.javaFileListFlavor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15368().isDataFlavorSupported(flavor));
    }
}
