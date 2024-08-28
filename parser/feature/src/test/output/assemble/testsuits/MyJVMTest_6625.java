import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_6625 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1 = 803;

    static int dtdeParam2Param2 = 757;

    static Point dtdeParam2 = new Point(dtdeParam2Param1, dtdeParam2Param2);

    static int dtdeParam3 = 188;

    static int dtdeParam4 = 157;

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

    DropTargetDragEvent dragOver(DropTargetDragEvent dtde) {
        check(dtde);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6625().dragOver(dtde);
    }
}
