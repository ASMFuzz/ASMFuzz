public class MyJVMTest_14354 {

    static int x = 0;

    static int y = 0;

    Object doStrictFloorMod(int x, int y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14354().doStrictFloorMod(x, y));
    }
}
