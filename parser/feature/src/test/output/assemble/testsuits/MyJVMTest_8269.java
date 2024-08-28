import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.applet.Applet;

public class MyJVMTest_8269 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1Param1 = 726;

    static int dtdeParam2Param1Param2 = 518;

    static Point dtdeParam2Param1 = new Point(dtdeParam2Param1Param1, dtdeParam2Param1Param2);

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 899;

    static int dtdeParam4 = 711;

    static DropTargetDropEvent dtde = new DropTargetDropEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    static boolean[] successCodes = { true, false };

    static int dropCount = 0;

    DropTargetDropEvent drop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(DnDConstants.ACTION_COPY);
        dtde.dropComplete(successCodes[dropCount]);
        dropCount++;
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8269().drop(dtde);
    }
}
