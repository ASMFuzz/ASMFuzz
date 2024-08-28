import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_10891 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2 = new Point();

    static int dtdeParam3 = 653;

    static int dtdeParam4 = 531;

    static DropTargetDropEvent dtde = new DropTargetDropEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    static boolean testFailed = false;

    DropTargetDropEvent drop(DropTargetDropEvent dtde) {
        dtde.rejectDrop();
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10891().drop(dtde);
    }
}
