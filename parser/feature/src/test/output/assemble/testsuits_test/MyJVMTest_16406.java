public class MyJVMTest_16406 {

    static byte[] dst = { -35, 68, -63, -91, -111, -117, -28, 98, 100, -88 };

    byte[] getSrc() {
        return new byte[5];
    }

    byte[] test1(byte[] dst) {
        byte[] src = getSrc();
        try {
            System.arraycopy(src, Integer.MAX_VALUE - 1, dst, 0, src.length);
        } catch (Exception e) {
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16406().test1(dst);
    }
}
