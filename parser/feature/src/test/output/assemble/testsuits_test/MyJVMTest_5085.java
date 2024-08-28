import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_5085 {

    static DropTargetContext dtdeParam1 = null;

    static int dtdeParam2Param1 = 260;

    static int dtdeParam2Param2 = 89;

    static Point dtdeParam2 = new Point(dtdeParam2Param1, dtdeParam2Param2);

    static int dtdeParam3 = 927;

    static int dtdeParam4 = 182;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    DropTargetDragEvent dragEnter(DropTargetDragEvent dtde) {
        dtde.acceptDrag(DnDConstants.ACTION_COPY);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5085().dragEnter(dtde);
    }
}
