public class MyJVMTest_18014 {

    static int x = 5;

    static int y = -1211328916;

    int safeMethod(int x, int y) {
        long r = (long) x * (long) y;
        if ((int) r != r) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18014().safeMethod(x, y));
    }
}
