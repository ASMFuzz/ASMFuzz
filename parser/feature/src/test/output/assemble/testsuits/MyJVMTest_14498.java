import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_14498 {

    static DropTargetContext dtdeParam1 = null;

    static Point dtdeParam2 = new Point();

    static int dtdeParam3 = 177;

    static int dtdeParam4 = 207;

    static DropTargetDragEvent dtde = new DropTargetDragEvent(dtdeParam1, dtdeParam2, dtdeParam3, dtdeParam4);

    DropTargetDragEvent dragEnter(DropTargetDragEvent dtde) {
        dtde.acceptDrag(DnDConstants.ACTION_COPY);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14498().dragEnter(dtde);
    }
}
