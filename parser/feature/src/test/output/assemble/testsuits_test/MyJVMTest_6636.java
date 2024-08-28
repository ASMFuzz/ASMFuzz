import java.awt.Color;
import java.util.Arrays;

public class MyJVMTest_6636 {

    static int cParam1 = 472;

    static int cParam2 = 800;

    static int cParam3 = 542;

    static Color c = new Color(cParam1, cParam2, cParam3);

    float[] hsb(Color c) {
        return Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6636().hsb(c)));
    }
}
