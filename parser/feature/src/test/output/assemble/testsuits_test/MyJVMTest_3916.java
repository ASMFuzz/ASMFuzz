public class MyJVMTest_3916 {

    static long x = 0;

    static int y = 0;

    Object doStrictFloorMod(long x, int y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3916().doStrictFloorMod(x, y));
    }
}
