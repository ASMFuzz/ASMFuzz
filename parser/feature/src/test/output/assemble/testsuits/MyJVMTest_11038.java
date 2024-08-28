import java.awt.DisplayMode;

public class MyJVMTest_11038 {

    static int displayModeParam1 = 11;

    static int displayModeParam2 = 611;

    static int displayModeParam3 = 511;

    static int displayModeParam4 = 44;

    static DisplayMode displayMode = new DisplayMode(displayModeParam1, displayModeParam2, displayModeParam3, displayModeParam4);

    DisplayMode checkDisplayMode(DisplayMode displayMode) {
        if (displayMode == null || displayMode.getWidth() <= 1 || displayMode.getHeight() <= 1) {
            throw new RuntimeException("invalid display mode");
        }
        return displayMode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11038().checkDisplayMode(displayMode);
    }
}
