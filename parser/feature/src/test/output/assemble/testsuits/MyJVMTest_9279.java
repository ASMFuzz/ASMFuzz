import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MyJVMTest_9279 {

    static DragSourceContextPeer dtdeParam1Param1 = null;

    static DragGestureRecognizer dtdeParam1Param2Param1 = null;

    static int dtdeParam1Param2Param2 = 851;

    static int dtdeParam1Param2Param3Param1 = 559;

    static int dtdeParam1Param2Param3Param2 = 957;

    static Point dtdeParam1Param2Param3 = new Point(dtdeParam1Param2Param3Param1, dtdeParam1Param2Param3Param2);

    static List<? extends InputEvent> dtdeParam1Param2Param4 = new ArrayList<? extends InputEvent>();

    static DragGestureEvent dtdeParam1Param2 = new DragGestureEvent(dtdeParam1Param2Param1, dtdeParam1Param2Param2, dtdeParam1Param2Param3, dtdeParam1Param2Param4);

    static Cursor dtdeParam1Param3 = new Cursor();

    static Image dtdeParam1Param4 = null;

    static Point dtdeParam1Param5 = new Point();

    static Transferable dtdeParam1Param6 = null;

    static DragSourceListener dtdeParam1Param7 = null;

    static DragSourceContext dtdeParam1 = new DragSourceContext(dtdeParam1Param1, dtdeParam1Param2, dtdeParam1Param3, dtdeParam1Param4, dtdeParam1Param5, dtdeParam1Param6, dtdeParam1Param7);

    static DragSourceDropEvent dtde = new DragSourceDropEvent(dtdeParam1);

    DragSourceDropEvent dragDropEnd(DragSourceDropEvent dtde) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return dtde;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9279().dragDropEnd(dtde);
    }
}
