public class MyJVMTest_7636 {

    static long x = 9223372036854775807L;

    static long y = 0;

    Object doFloorMod(long x, long y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7636().doFloorMod(x, y));
    }
}
