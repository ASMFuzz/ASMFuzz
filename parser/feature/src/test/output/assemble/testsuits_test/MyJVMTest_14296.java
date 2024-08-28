public class MyJVMTest_14296 {

    static int paddedSize = 0;

    void padV15_5() {
        byte[] padded = new byte[paddedSize];
        int psSize = padded.length;
        int k = psSize - 1;
        for (int i = 0; i < psSize; i++) {
            padded[k--] = (byte) 0xff;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14296().padV15_5();
    }
}
