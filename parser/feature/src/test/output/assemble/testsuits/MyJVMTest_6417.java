import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_6417 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1 = 950;

    static int dtdeParam2Param2 = 409;

    static Point dtdeParam2 = new Point(dtdeParam2Param1, dtdeParam2Param2);

    static int dtdeParam3 = 126;

    static int dtdeParam4 = 333;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    DropTargetDragEvent dragOver(DropTargetDragEvent dtde) {
        dtde.acceptDrag(DnDConstants.ACTION_COPY);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6417().dragOver(dtde);
    }
}
