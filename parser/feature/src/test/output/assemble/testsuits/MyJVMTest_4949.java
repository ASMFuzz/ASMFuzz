public class MyJVMTest_4949 {

    static int x = -1561389152;

    static int y = 601516906;

    Object doStrictFloorMod(int x, int y) {
        try {
            return StrictMath.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4949().doStrictFloorMod(x, y));
    }
}
