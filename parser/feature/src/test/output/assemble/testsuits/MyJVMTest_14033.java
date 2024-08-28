import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_14033 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1Param1 = 404;

    static int dtdeParam2Param1Param2 = 346;

    static Point dtdeParam2Param1 = new Point(dtdeParam2Param1Param1, dtdeParam2Param1Param2);

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 835;

    static int dtdeParam4 = 361;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    static boolean testFailed = false;

    DropTargetDragEvent dragOver(DropTargetDragEvent dtde) {
        try {
            dtde.getCurrentDataFlavorsAsList();
        } catch (Exception e) {
            testFailed = true;
            e.printStackTrace();
        }
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14033().dragOver(dtde);
    }
}
