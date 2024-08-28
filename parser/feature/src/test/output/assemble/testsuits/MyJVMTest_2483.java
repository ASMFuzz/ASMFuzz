public class MyJVMTest_2483 {

    static boolean b = false;

    static boolean c = true;

    static long longs = 9223372036854775807L;

    static int a = 6;

    boolean maybeMaskBits2(boolean b, boolean c) {
        if (b) {
            longs &= 0x1F1F1F1F;
        }
        if (c) {
            a += 344;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2483().maybeMaskBits2(b, c);
    }
}
