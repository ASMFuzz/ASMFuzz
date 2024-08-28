import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_3024 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1 = 794;

    static int dtdeParam2Param2 = 961;

    static Point dtdeParam2 = new Point(dtdeParam2Param1, dtdeParam2Param2);

    static int dtdeParam3 = 240;

    static int dtdeParam4 = 253;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    static Color bgColor = null;

    static Color htColor = null;

    boolean check(DropTargetDragEvent dtde) {
        if (dtde.getCurrentDataFlavorsAsList().contains(DataFlavor.javaFileListFlavor)) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3024().check(dtde));
    }
}
