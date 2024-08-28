public class MyJVMTest_12668 {

    static long x = 0;

    static int y = 7883155;

    Object doStrictFloorDiv(long x, int y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12668().doStrictFloorDiv(x, y));
    }
}
