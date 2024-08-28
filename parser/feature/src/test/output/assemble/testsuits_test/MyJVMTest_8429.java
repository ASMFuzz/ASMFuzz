public class MyJVMTest_8429 {

    static int x = 9;

    static int y = 5;

    int safeMethod(int x, int y) {
        long r = (long) x * (long) y;
        if ((int) r != r) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8429().safeMethod(x, y));
    }
}
