public class MyJVMTest_11891 {

    static long x = -9223372036854775808L;

    static long y = 3628502516054856455L;

    Object doFloorDiv(long x, long y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11891().doFloorDiv(x, y));
    }
}
