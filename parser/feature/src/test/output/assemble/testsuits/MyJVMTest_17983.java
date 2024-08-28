import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17983 {

    static int width = 300;

    static int height = 200;

    static int hGap = 9, vGap = 0;

    static int rows = 3;

    static int columns = 2;

    static int componentCount = 6;

    static Button[] buttons = {null,null,null,null,null,null,null,null,null,null};

    static Frame frame = null;

    static Robot robot = null;

    static GridLayout layout = null;

    static boolean actionPerformed = false;

    void changeGridSize() throws Exception {
        EventQueue.invokeAndWait(() -> {
            layout.setRows(rows);
            layout.setColumns(columns);
            frame.revalidate();
        });
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17983().changeGridSize();
    }
}
