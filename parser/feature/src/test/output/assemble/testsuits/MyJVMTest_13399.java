import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_13399 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1Param1 = 207;

    static int dtdeParam2Param1Param2 = 689;

    static Point dtdeParam2Param1 = new Point(dtdeParam2Param1Param1, dtdeParam2Param1Param2);

    static Point dtdeParam2 = new Point(dtdeParam2Param1);

    static int dtdeParam3 = 908;

    static int dtdeParam4 = 881;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    DropTargetDragEvent dropActionChanged(DropTargetDragEvent dtde) {
        dtde.acceptDrag(DnDConstants.ACTION_COPY);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13399().dropActionChanged(dtde);
    }
}
