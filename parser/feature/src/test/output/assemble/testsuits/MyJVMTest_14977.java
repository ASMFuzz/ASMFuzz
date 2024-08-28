public class MyJVMTest_14977 {

    static long x = 0;

    static int y = 1;

    Object doFloorDiv(long x, int y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14977().doFloorDiv(x, y));
    }
}
