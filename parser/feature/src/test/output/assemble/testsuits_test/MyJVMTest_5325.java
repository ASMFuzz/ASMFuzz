import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyJVMTest_5325 {

    static int colorParam1 = 702;

    static Color color = new Color(colorParam1);

    static Window win = null;

    float[] getHSB(final Color color) {
        final float[] hsb = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
        return hsb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5325().getHSB(color)));
    }
}
