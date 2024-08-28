public class MyJVMTest_1081 {

    static long x = -9223372036854775808L;

    static long y = 9223372036854775807L;

    Object doStrictFloorDiv(long x, long y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1081().doStrictFloorDiv(x, y));
    }
}
