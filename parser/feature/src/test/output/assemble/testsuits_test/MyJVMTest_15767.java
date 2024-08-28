import java.awt.Color;

public class MyJVMTest_15767 {

    static int color1 = 0;

    static int color2 = 0;

    boolean isSameColor(int color1, int color2) {
        final int tolerance = 2;
        for (int i = 0; i < 32; i += 8) {
            int c1 = 0xff & (color1 >> i);
            int c2 = 0xff & (color2 >> i);
            if (Math.abs(c1 - c2) > tolerance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15767().isSameColor(color1, color2));
    }
}
