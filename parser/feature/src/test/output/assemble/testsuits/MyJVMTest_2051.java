public class MyJVMTest_2051 {

    static int x = -895311328;

    static int y = 5;

    int safeMethod(int x, int y) {
        int r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2051().safeMethod(x, y));
    }
}
