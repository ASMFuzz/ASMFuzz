public class MyJVMTest_9657 {

    static int x = 298680496;

    static int y = 1511807844;

    Object doFloorDiv(int x, int y) {
        try {
            return Math.floorDiv(x, y);
        } catch (ArithmeticException ae) {
            return ae;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9657().doFloorDiv(x, y));
    }
}
