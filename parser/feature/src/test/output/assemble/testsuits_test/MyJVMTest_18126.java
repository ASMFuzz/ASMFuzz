public class MyJVMTest_18126 {

    static boolean b = true;

    static int i = 0;

    static float f = Float.POSITIVE_INFINITY;

    int vMeth(boolean b, int i, float f) {
        int i1 = -4, i2 = 14, i16 = 10;
        byte by = 116;
        for (i1 = 323; i1 > 3; i1 -= 2) {
            if (i2 != 0) {
                return;
            }
            for (i16 = 1; i16 < 10; i16++) {
                i2 = by;
                i += (i16 - i2);
                i2 -= i16;
                if (b) {
                    i = by;
                }
                i2 *= 20;
            }
        }
        return i16;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18126().vMeth(b, i, f);
    }
}
