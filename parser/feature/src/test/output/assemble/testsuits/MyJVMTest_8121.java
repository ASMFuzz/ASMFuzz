public class MyJVMTest_8121 {

    static long[] result = { 0, 0, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, -3724444526088041235L, 9223372036854775807L, 0, 9223372036854775807L };

    static double d1 = Double.MIN_VALUE;

    static double d2 = Double.MIN_VALUE;

    long[] check_double(long[] result, double d1, double d2) {
        if (result[0] == result[1]) {
            throw new RuntimeException("ERROR: Two different double values are considered equal. \n" + String.format("\toriginal values: 0x%x 0x%x\n", Double.doubleToRawLongBits(d1), Double.doubleToRawLongBits(d2)) + String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8121().check_double(result, d1, d2);
    }
}
