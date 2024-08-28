public class MyJVMTest_3341 {

    static long x = 3458486416571470631L;

    static int y = 0;

    Object doStrictFloorDiv(long x, int y) {
        try {
            return StrictMath.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3341().doStrictFloorDiv(x, y));
    }
}
