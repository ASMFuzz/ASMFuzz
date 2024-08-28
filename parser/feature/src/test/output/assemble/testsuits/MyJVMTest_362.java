public class MyJVMTest_362 {

    static int[] input = {8,0,9,9,0,9,-136654564,1,0,-878902235};

    static int[] output = {0,7,0,654668144,9,7,7,-983685578,0,907754936};

    static int LEN = 1024;

    void vectorizeBitCount() {
        for (int i = 0; i < LEN; ++i) {
            output[i] = Integer.bitCount(input[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_362().vectorizeBitCount();
    }
}
