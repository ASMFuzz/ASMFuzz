public class MyJVMTest_11752 {

    static boolean b = false;

    static boolean c = true;

    static long longs = 0;

    static int a = 1284190747;

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
        new MyJVMTest_11752().maybeMaskBits2(b, c);
    }
}
