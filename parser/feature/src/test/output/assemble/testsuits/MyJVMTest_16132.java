import java.awt.Color;
import java.util.Arrays;

public class MyJVMTest_16132 {

    static Color c = new Color();

    float[] hsb(Color c) {
        return Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16132().hsb(c)));
    }
}
