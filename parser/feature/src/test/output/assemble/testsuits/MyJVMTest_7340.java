public class MyJVMTest_7340 {

    static int paddedSize = 0;

    void padV15_4() {
        byte[] padded = new byte[paddedSize];
        int psSize = padded.length;
        for (int k = 0; psSize > 0; psSize--) {
            int i = padded.length - psSize;
            padded[i] = (byte) 0xff;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7340().padV15_4();
    }
}
