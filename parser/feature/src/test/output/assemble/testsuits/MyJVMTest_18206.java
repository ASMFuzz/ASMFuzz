public class MyJVMTest_18206 {

    static int x = 8;

    static int y = 7;

    Object doStrictFloorDiv(int x, int y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18206().doStrictFloorDiv(x, y));
    }
}
