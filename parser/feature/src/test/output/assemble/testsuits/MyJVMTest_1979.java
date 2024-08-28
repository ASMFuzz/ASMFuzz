public class MyJVMTest_1979 {

    static int[] result = { 0, 7, 0, -1022871996, 234626228, 9, 0, 6, 0, 0 };

    static float f1 = 0f;

    static float f2 = 0.72796315f;

    int[] check_float(int[] result, float f1, float f2) {
        if (result[0] == result[1]) {
            throw new RuntimeException("ERROR: Two different float values are considered equal. \n" + String.format("\toriginal values: 0x%x 0x%x\n", Float.floatToRawIntBits(f1), Float.floatToRawIntBits(f2)) + String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1979().check_float(result, f1, f2);
    }
}
