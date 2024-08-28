public class MyJVMTest_4262 {

    static long x = 8194425809888356374L;

    static long y = 6698564780860802987L;

    Object doStrictFloorMod(long x, long y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4262().doStrictFloorMod(x, y));
    }
}
