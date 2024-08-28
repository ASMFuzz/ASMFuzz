import java.awt.DisplayMode;

public class MyJVMTest_906 {

    static int dmParam1 = 286;

    static int dmParam2 = 276;

    static int dmParam3 = 902;

    static int dmParam4 = 571;

    static DisplayMode dm = new DisplayMode(dmParam1, dmParam2, dmParam3, dmParam4);

    DisplayMode deriveSize(DisplayMode dm) {
        int w = dm.getWidth() / 7;
        int h = dm.getHeight() / 3;
        return new DisplayMode(w, h, dm.getBitDepth(), dm.getRefreshRate());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_906().deriveSize(dm));
    }
}
