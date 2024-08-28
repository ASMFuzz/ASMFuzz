public class MyJVMTest_3462 {

    static int initial = 7;

    static int iterations = 1164707822;

    static boolean shiftLeft = true;

    static int GENERATOR = 0x04C11DB7;

    static int SHIFT_RIGHT_GENERATOR = 0xEDB88320;

    int runLfsr(int initial, int iterations) {
        int newValue = initial;
        for (int i = 0; i < iterations; ++i) {
            if (shiftLeft) {
                if ((newValue & 0x80000000) != 0) {
                    newValue <<= 1;
                    newValue ^= GENERATOR;
                } else {
                    newValue <<= 1;
                }
            } else {
                if ((newValue & 0x1) != 0) {
                    newValue = (newValue >> 1) & 0x7fffffff;
                    newValue ^= SHIFT_RIGHT_GENERATOR;
                } else {
                    newValue = (newValue >> 1) & 0x7fffffff;
                }
            }
        }
        return newValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3462().runLfsr(initial, iterations));
    }
}
