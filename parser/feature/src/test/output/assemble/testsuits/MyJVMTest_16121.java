import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_16121 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2 = new Point();

    static int dtdeParam3 = 172;

    static int dtdeParam4 = 29;

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
        new MyJVMTest_16121().dragOver(dtde);
    }
}
