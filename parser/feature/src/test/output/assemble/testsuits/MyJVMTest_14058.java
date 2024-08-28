import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_14058 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2Param1 = new Point();

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 740;

    static int dtdeParam4 = 992;

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
        new MyJVMTest_14058().dropActionChanged(dtde);
    }
}
