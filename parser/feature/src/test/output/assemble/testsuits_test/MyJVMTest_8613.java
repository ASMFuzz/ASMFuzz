public class MyJVMTest_8613 {

    static int x = 169719926;

    static int y = 0;

    Object doStrictFloorDiv(int x, int y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8613().doStrictFloorDiv(x, y));
    }
}
