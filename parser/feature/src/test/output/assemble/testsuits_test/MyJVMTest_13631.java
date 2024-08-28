public class MyJVMTest_13631 {

    static long x = -4285255217090538605L;

    static long y = 3966148865099135303L;

    Object doStrictFloorMod(long x, long y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13631().doStrictFloorMod(x, y));
    }
}
