public class MyJVMTest_13260 {

    static long x = 3813850596485216359L;

    static int y = 3;

    Object doStrictFloorMod(long x, int y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13260().doStrictFloorMod(x, y));
    }
}
