public class MyJVMTest_2244 {

    static byte[] padded = { -88, 15, 105, -14, 55, -123, 113, 104, -9, -18 };

    byte[] padV15(byte[] padded) {
        int psSize = padded.length;
        int k = 0;
        while (psSize-- > 0) {
            padded[k++] = (byte) 0xff;
        }
        return padded;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2244().padV15(padded);
    }
}
