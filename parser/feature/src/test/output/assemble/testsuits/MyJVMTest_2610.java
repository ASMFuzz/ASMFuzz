public class MyJVMTest_2610 {

    static long x = -9223372036854775808L;

    static long y = -9223372036854775808L;

    Object doFloorDiv(long x, long y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2610().doFloorDiv(x, y));
    }
}
