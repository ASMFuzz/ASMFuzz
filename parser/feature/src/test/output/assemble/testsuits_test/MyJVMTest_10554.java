public class MyJVMTest_10554 {

    static int x = 5;

    static int y = 0;

    Object doFloorMod(int x, int y) {
        try {
            return Math.floorMod(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10554().doFloorMod(x, y));
    }
}
