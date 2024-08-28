public class MyJVMTest_13230 {

    static byte[] b1 = { 59, -118, -28, -119, 79, -10, -48, 2, 118, -111 };

    static byte[] b2 = { -93, -108, 46, 36, -15, 119, 115, 115, 66, -115 };

    static int b1BKSize = 1;

    static int b2BKSize = 2133595418;

    boolean equalsBlockPartial(byte[] b1, byte[] b2, int b1BKSize, int b2BKSize) {
        int numOfBlock = b1.length / b1BKSize;
        for (int b = 0; b < numOfBlock; b++) {
            for (int i = 0; i < b2BKSize; i++) {
                int j1 = b * b1BKSize + i;
                int j2 = b * b2BKSize + i;
                if (b1[j1] != b2[j2]) {
                    System.err.println("Compare failed at b1[" + j1 + "]:" + b1[j1] + " b2[" + j2 + "]:" + b2[j2]);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13230().equalsBlockPartial(b1, b2, b1BKSize, b2BKSize));
    }
}
