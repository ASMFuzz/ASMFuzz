public class MyJVMTest_2896 {

    static int[] input = {7,0,3,7,6,5,1011731151,7,0,9};

    static int[] output = {123008074,5,8,4,2,-988252560,6,5,3,0};

    static int LEN = 1024;

    void checkResult() {
        for (int i = 0; i < LEN; ++i) {
            int expected = Integer.bitCount(input[i]);
            if (output[i] != expected) {
                throw new RuntimeException("Invalid result: output[" + i + "] = " + output[i] + " != " + expected);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2896().checkResult();
    }
}
