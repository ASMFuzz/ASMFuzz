public class MyJVMTest_4465 {

    static boolean b = false;

    static long longs = 0;

    static int a = 7;

    boolean maybeMaskBits(boolean b) {
        if (b) {
            longs &= 0x1F1F1F1F;
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4465().maybeMaskBits(b);
    }
}
