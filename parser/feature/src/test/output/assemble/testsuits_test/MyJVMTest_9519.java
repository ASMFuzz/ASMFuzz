public class MyJVMTest_9519 {

    static int[] input = {9,9,9,7,0,2,-319993397,9,8,844552873};

    static int[] output = {5,1,-682126172,5,1174502321,4,9,4,0,11204196};

    static int LEN = 1024;

    void vectorizeBitCount() {
        for (int i = 0; i < LEN; ++i) {
            output[i] = Integer.bitCount(input[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9519().vectorizeBitCount();
    }
}
