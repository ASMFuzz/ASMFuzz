public class MyJVMTest_12195 {

    static int[] input = {1178753312,-50595334,0,-1449731785,6,0,0,9,0,0};

    static int[] output = {412254599,0,2,8,9,0,-1727301427,-1756893800,-1507915506,-777348452};

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
        new MyJVMTest_12195().checkResult();
    }
}
