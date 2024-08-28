import java.awt.DisplayMode;

public class MyJVMTest_15194 {

    static int dmParam1 = 419;

    static int dmParam2 = 49;

    static int dmParam3 = 661;

    static int dmParam4 = 440;

    static DisplayMode dm = new DisplayMode(dmParam1, dmParam2, dmParam3, dmParam4);

    DisplayMode deriveRR(DisplayMode dm) {
        return new DisplayMode(dm.getWidth(), dm.getHeight(), dm.getBitDepth(), 777);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15194().deriveRR(dm));
    }
}
