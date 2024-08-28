public class MyJVMTest_13850 {

    static boolean b = false;

    static long longs = -1584694369876279225L;

    static int a = 1538010790;

    boolean maybeMaskBits(boolean b) {
        if (b) {
            longs &= 0x1F1F1F1F;
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13850().maybeMaskBits(b);
    }
}
