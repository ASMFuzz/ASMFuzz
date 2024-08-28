public class MyJVMTest_17184 {

    static long x = -9223372036854775808L;

    static long y = 9223372036854775807L;

    Object doFloorMod(long x, long y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17184().doFloorMod(x, y));
    }
}
