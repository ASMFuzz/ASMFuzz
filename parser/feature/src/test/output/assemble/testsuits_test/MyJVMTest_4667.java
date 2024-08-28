import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_4667 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2 = new Point();

    static int dtdeParam3 = 663;

    static int dtdeParam4 = 389;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    boolean check(DropTargetDragEvent dtde) {
        if (dtde.getCurrentDataFlavorsAsList().contains(DataFlavor.javaFileListFlavor)) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY);
            return true;
        }
        return false;
    }

    static Color bgColor = null;

    static Color htColor = null;

    DropTargetDragEvent dropActionChanged(DropTargetDragEvent dtde) {
        check(dtde);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4667().dropActionChanged(dtde);
    }
}
