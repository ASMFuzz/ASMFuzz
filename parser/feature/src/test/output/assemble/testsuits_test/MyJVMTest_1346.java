public class MyJVMTest_1346 {

    static int x = -647737552;

    static int y = 6;

    Object doFloorMod(int x, int y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1346().doFloorMod(x, y));
    }
}
