import java.awt.DisplayMode;

public class MyJVMTest_13944 {

    static int dmParam1 = 996;

    static int dmParam2 = 182;

    static int dmParam3 = 34;

    static int dmParam4 = 300;

    static DisplayMode dm = new DisplayMode(dmParam1, dmParam2, dmParam3, dmParam4);

    DisplayMode deriveDepth(DisplayMode dm) {
        int depth;
        if (dm.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI) {
            depth = 77;
        } else {
            depth = DisplayMode.BIT_DEPTH_MULTI;
        }
        return new DisplayMode(dm.getWidth(), dm.getHeight(), depth, dm.getRefreshRate());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13944().deriveDepth(dm));
    }
}
