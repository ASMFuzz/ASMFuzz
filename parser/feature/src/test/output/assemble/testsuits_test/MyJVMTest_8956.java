public class MyJVMTest_8956 {

    static int val = -1793546373;

    int testRorIntZero(int val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        int res = Integer.rotateRight(val, count);
        if (res != val) {
            throw new RuntimeException("test_ror_int_zero failed: " + res + " != " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8956().testRorIntZero(val);
    }
}
