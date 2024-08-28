public class MyJVMTest_17961 {

    static long x = 8598098908232815234L;

    static int y = 0;

    Object doFloorMod(long x, int y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17961().doFloorMod(x, y));
    }
}
