public class MyJVMTest_10977 {

    static byte[] src = { 49, -126, 117, -46, 42, -111, 125, 26, 93, -54 };

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
        new MyJVMTest_10977().test2(src);
    }
}
