import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9892 {

    void changeGridSize() throws Exception {
        EventQueue.invokeAndWait(() -> {
            layout.setRows(rows);
            layout.setColumns(columns);
            frame.revalidate();
        });
        robot.waitForIdle();
    }

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

    void testBoundaries(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) throws Exception {
        actionPerformed = false;
        robot.mouseMove(topLeftX, topLeftY);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(3000);
        if (!actionPerformed) {
            frame.dispose();
            throw new RuntimeException("Clicking on the left top of button did not trigger action event");
        }
        actionPerformed = false;
        robot.mouseMove(bottomRightX, bottomRightY);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(3000);
        if (!actionPerformed) {
            frame.dispose();
            throw new RuntimeException("Clicking on the bottom right of button did not trigger action event");
        }
    }

    static int width = 300;

    static int height = 200;

    static int hGap = 8, vGap = 0;

    static int rows = 3;

    static int columns = 2;

    static int componentCount = 6;

    static Button[] buttons = {null,null,null,null,null,null,null,null,null,null};

    static Frame frame = null;

    static Robot robot = null;

    static GridLayout layout = null;

    static boolean actionPerformed = false;

    void doTest() throws Exception {
        robot.waitForIdle();
        changeGridSize();
        resizeFrame();
        int availableWidth = width - frame.getInsets().left - frame.getInsets().right;
        int componentWidth = (availableWidth + hGap) / columns - hGap;
        int availableHeight = height - frame.getInsets().top - frame.getInsets().bottom;
        int componentHeight = (availableHeight + vGap) / rows - vGap;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getSize().width != componentWidth || buttons[i].getSize().height != componentHeight) {
                frame.dispose();
                throw new RuntimeException("FAIL: Button " + i + " not of proper size" + "Expected: " + componentWidth + "*" + componentHeight + "Actual: " + buttons[i].getSize().width + "*" + buttons[i].getSize().height);
            }
        }
        int currentRow = 1;
        int currentColumn = 0;
        for (int i = 0; i < buttons.length; i++) {
            currentColumn++;
            if (currentColumn > columns) {
                currentColumn = 1;
                currentRow++;
            }
            int topPosX = frame.getLocationOnScreen().x + frame.getInsets().left + (currentColumn - 1) * (componentWidth + hGap);
            int topPosY = frame.getLocationOnScreen().y + frame.getInsets().top + (currentRow - 1) * (componentHeight + vGap);
            int bottomPosX = topPosX + componentWidth - 1;
            int bottomPosY = topPosY + componentHeight - 1;
            testBoundaries(topPosX, topPosY, bottomPosX, bottomPosY);
        }
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9892().doTest();
    }
}
