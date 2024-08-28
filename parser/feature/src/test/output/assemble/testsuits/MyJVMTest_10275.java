public class MyJVMTest_10275 {

    static long x = 0;

    static long y = 0;

    Object doStrictFloorDiv(long x, long y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10275().doStrictFloorDiv(x, y));
    }
}
