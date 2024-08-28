import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_1669 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2Param1 = new Point();

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 644;

    static int dtdeParam4 = 214;

    static DropTargetDropEvent dtde = new DropTargetDropEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    static boolean testFailed = false;

    DropTargetDropEvent drop(DropTargetDropEvent dtde) {
        dtde.rejectDrop();
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1669().drop(dtde);
    }
}
