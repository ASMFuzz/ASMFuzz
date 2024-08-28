public class MyJVMTest_11499 {

    static byte[] padded = { -102, -32, 52, 17, -62, -14, 90, 24, 47, 89 };

    byte[] padV15(byte[] padded) {
        int psSize = padded.length;
        int k = 0;
        while (psSize-- > 0) {
            padded[k++] = (byte) 0xff;
        }
        return padded;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11499().padV15(padded);
    }
}
