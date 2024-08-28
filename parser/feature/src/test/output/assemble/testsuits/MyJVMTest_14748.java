import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyJVMTest_14748 {

    static int colorParam1 = 948;

    static int colorParam2 = 672;

    static int colorParam3 = 417;

    static Color color = new Color(colorParam1, colorParam2, colorParam3);

    static Window win = null;

    float[] getHSB(final Color color) {
        final float[] hsb = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
        return hsb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14748().getHSB(color)));
    }
}
