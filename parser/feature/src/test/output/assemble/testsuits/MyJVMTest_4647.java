public class MyJVMTest_4647 {

    static int x = 0;

    static int y = 5;

    int safeMethod(int x, int y) {
        int r = x - y;
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4647().safeMethod(x, y));
    }
}
