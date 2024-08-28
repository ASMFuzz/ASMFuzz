public class MyJVMTest_6896 {

    static byte[] dst = { 105, -37, 32, -88, 51, -127, 85, -31, 107, -32 };

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
        new MyJVMTest_6896().test1(dst);
    }
}
