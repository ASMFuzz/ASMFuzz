public class MyJVMTest_14038 {

    static int x = -2080798567;

    static int y = 8;

    int safeMethod(int x, int y) {
        int r = x - y;
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14038().safeMethod(x, y));
    }
}
