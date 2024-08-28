public class MyJVMTest_11297 {

    static int x = 7;

    static int y = 0;

    int safeMethod(int x, int y) {
        int r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11297().safeMethod(x, y));
    }
}
