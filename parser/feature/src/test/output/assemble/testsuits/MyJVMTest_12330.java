import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;

public class MyJVMTest_12330 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1Param1Param1 = 749;

    static int dtdeParam2Param1Param1Param2 = 687;

    static Point dtdeParam2Param1Param1 = new Point(dtdeParam2Param1Param1Param1, dtdeParam2Param1Param1Param2);

    static Point dtdeParam2Param1 = new Point(dtdeParam2Param1Param1);

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 897;

    static int dtdeParam4 = 512;

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
        System.out.println(new MyJVMTest_12330().check(dtde));
    }
}
