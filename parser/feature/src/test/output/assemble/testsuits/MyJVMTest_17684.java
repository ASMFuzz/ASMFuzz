public class MyJVMTest_17684 {

    static int paddedSize = 0;

    void padV15_3() {
        byte[] padded = new byte[paddedSize];
        int psSize = padded.length;
        int k = 0;
        while (psSize-- > 0) {
            padded[k++] = (byte) 0xff;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17684().padV15_3();
    }
}
