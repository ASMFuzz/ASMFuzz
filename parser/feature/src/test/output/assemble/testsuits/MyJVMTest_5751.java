import java.awt.DisplayMode;

public class MyJVMTest_5751 {

    static int dmParam1 = 640;

    static int dmParam2 = 804;

    static int dmParam3 = 120;

    static int dmParam4 = 351;

    static DisplayMode dm = new DisplayMode(dmParam1, dmParam2, dmParam3, dmParam4);

    DisplayMode deriveRR(DisplayMode dm) {
        return new DisplayMode(dm.getWidth(), dm.getHeight(), dm.getBitDepth(), 777);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5751().deriveRR(dm));
    }
}
