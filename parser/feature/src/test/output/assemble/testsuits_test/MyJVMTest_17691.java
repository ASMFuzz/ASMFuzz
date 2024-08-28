public class MyJVMTest_17691 {

    static long[] result = { -5718849845335375642L, 9223372036854775807L, -5653952551688956574L, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -1486987466554230050L, -9223372036854775808L, -9223372036854775808L };

    static double d1 = 0d;

    static double d2 = 0.26448064389403725;

    long[] check_double(long[] result, double d1, double d2) {
        if (result[0] == result[1]) {
            throw new RuntimeException("ERROR: Two different double values are considered equal. \n" + String.format("\toriginal values: 0x%x 0x%x\n", Double.doubleToRawLongBits(d1), Double.doubleToRawLongBits(d2)) + String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17691().check_double(result, d1, d2);
    }
}
