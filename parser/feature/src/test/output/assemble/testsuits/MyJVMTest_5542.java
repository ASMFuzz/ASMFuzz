public class MyJVMTest_5542 {

    static long x = -9223372036854775808L;

    static int y = 7;

    Object doFloorDiv(long x, int y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5542().doFloorDiv(x, y));
    }
}
