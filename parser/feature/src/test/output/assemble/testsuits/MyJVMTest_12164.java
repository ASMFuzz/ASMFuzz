public class MyJVMTest_12164 {

    int bitTest() {
        int result = 0;
        int testValue = 73;
        int bitCount = Integer.bitCount(testValue);
        if (testValue != 0) {
            int gap = Long.numberOfTrailingZeros(testValue);
            testValue >>>= gap;
            while (testValue != 0) {
                result++;
                if ((testValue ^= 0x1) != 0) {
                    gap = Long.numberOfTrailingZeros(testValue);
                    testValue >>>= gap;
                }
            }
        }
        if (bitCount != result) {
            System.out.println("ERROR: " + bitCount + " != " + result);
            System.exit(97);
        }
        return (result);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12164().bitTest());
    }
}
