import java.awt.Color;

public class MyJVMTest_12538 {

    static float cParam1 = Float.NaN;

    static float cParam2 = Float.MAX_VALUE;

    static float cParam3 = Float.MAX_VALUE;

    static Color c = new Color(cParam1, cParam2, cParam3);

    float[] hsb(Color c) {
        return Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
    }

    String hsbString(Color c) {
        float[] hsb = hsb(c);
        return String.format("H=%.2f, S=%.2f, B=%.2f", hsb[0], hsb[1], hsb[2]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12538().hsbString(c));
    }
}
