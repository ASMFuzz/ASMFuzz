public class MyJVMTest_496 {

    static int x = 0;

    static int y = 9;

    Object doFloorDiv(int x, int y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_496().doFloorDiv(x, y));
    }
}
