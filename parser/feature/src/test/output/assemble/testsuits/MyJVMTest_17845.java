import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.applet.Applet;

public class MyJVMTest_17845 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2 = new Point();

    static int dtdeParam3 = 728;

    static int dtdeParam4 = 352;

    static boolean dtdeParam5 = true;

    static DropTargetDropEvent dtde = new DropTargetDropEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4, dtdeParam5);

    static boolean[] successCodes = { true, false };

    static int dropCount = 0;

    DropTargetDropEvent drop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(DnDConstants.ACTION_COPY);
        dtde.dropComplete(successCodes[dropCount]);
        dropCount++;
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17845().drop(dtde);
    }
}
