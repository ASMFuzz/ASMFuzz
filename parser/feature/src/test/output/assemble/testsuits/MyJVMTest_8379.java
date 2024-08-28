public class MyJVMTest_8379 {

    static long x = -9223372036854775808L;

    static int y = 9;

    Object doFloorMod(long x, int y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8379().doFloorMod(x, y));
    }
}
