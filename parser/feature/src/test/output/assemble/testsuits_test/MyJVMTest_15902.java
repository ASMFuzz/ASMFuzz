import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_15902 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2Param1Param1Param1 = new Point();

    static Point dtdeParam2Param1Param1 = new Point(dtdeParam2Param1Param1Param1);

    static Point dtdeParam2Param1 = new Point(dtdeParam2Param1Param1);

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 434;

    static int dtdeParam4 = 558;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    DropTargetDragEvent dragOver(DropTargetDragEvent dtde) {
        dtde.acceptDrag(DnDConstants.ACTION_COPY);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15902().dragOver(dtde);
    }
}
