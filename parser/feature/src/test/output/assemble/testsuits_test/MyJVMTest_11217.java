public class MyJVMTest_11217 {

    static int[] result = { 9, 0, 0, 0, 0, 0, 4, -787504439, 2, 2702194 };

    static float f1 = Float.MAX_VALUE;

    static float f2 = Float.NaN;

    int[] check_float(int[] result, float f1, float f2) {
        if (result[0] == result[1]) {
            throw new RuntimeException("ERROR: Two different float values are considered equal. \n" + String.format("\toriginal values: 0x%x 0x%x\n", Float.floatToRawIntBits(f1), Float.floatToRawIntBits(f2)) + String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11217().check_float(result, f1, f2);
    }
}
