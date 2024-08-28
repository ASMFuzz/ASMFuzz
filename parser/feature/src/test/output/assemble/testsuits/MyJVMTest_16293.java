import java.awt.*;

public class MyJVMTest_16293 {

    static int width = 300;

    static int height = 200;

    static int hGap = -357919301, vGap = -630618942;

    static int rows = 3;

    static int columns = 2;

    static int componentCount = 6;

    static Button[] buttons = {null,null,null,null,null,null,null,null,null,null};

    static Frame frame = null;

    static Robot robot = null;

    static GridLayout layout = null;

    static boolean actionPerformed = false;

    void resizeFrame() throws Exception {
        EventQueue.invokeAndWait(() -> {
            Insets insets = frame.getInsets();
            double dH = (height - insets.top - insets.bottom - vGap * (rows - 1)) % rows;
            double dW = (width - insets.left - insets.right - hGap * (columns - 1)) % columns;
            height -= dH;
            width -= dW;
            frame.setSize(width, height);
            frame.revalidate();
        });
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16293().resizeFrame();
    }
}
