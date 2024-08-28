public class MyJVMTest_3233 {

    static int paddedSize = 9;

    byte[] padV15_2(int paddedSize) {
        byte[] padded = new byte[paddedSize];
        int psSize = padded.length;
        int k = 0;
        while (psSize-- > 0) {
            padded[k++] = (byte) 0xff;
        }
        return padded;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3233().padV15_2(paddedSize);
    }
}
