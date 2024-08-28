import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

public class MyJVMTest_5917 {

    static DataFlavor flavor = new DataFlavor();

    boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.javaFileListFlavor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5917().isDataFlavorSupported(flavor));
    }
}
