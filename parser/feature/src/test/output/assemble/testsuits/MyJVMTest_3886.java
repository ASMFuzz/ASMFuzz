public class MyJVMTest_3886 {

    static byte[] b1 = { 7, 88, -93, -68, 47, -121, -53, -108, -49, -126 };

    static byte[] b2 = { -29, -45, 126, 101, -15, -65, -91, -113, 22, 90 };

    static int b1BKSize = 0;

    static int b2BKSize = 0;

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
        System.out.println(new MyJVMTest_3886().equalsBlockPartial(b1, b2, b1BKSize, b2BKSize));
    }
}
