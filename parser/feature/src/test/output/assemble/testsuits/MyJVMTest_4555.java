import java.awt.DisplayMode;

public class MyJVMTest_4555 {

    static int dmParam1 = 929;

    static int dmParam2 = 413;

    static int dmParam3 = 558;

    static int dmParam4 = 135;

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
        System.out.println(new MyJVMTest_4555().deriveDepth(dm));
    }
}
