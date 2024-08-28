public class MyJVMTest_1754 {

    static byte[] src = { -108, -57, 97, -113, -97, 114, -38, -87, 83, -21 };

    byte[] getDst() {
        return new byte[5];
    }

    byte[] test2(byte[] src) {
        byte[] dst = getDst();
        try {
            System.arraycopy(src, 0, dst, Integer.MAX_VALUE - 1, dst.length);
        } catch (Exception e) {
        }
        return dst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1754().test2(src);
    }
}
