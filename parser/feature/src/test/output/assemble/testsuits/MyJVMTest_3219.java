import java.awt.Color;

public class MyJVMTest_3219 {

    static int cParam1 = 434;

    static boolean cParam2 = true;

    static Color c = new Color(cParam1, cParam2);

    float[] hsb(Color c) {
        return Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
    }

    String hsbString(Color c) {
        float[] hsb = hsb(c);
        return String.format("H=%.2f, S=%.2f, B=%.2f", hsb[0], hsb[1], hsb[2]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3219().hsbString(c));
    }
}
