public class MyJVMTest_13444 {

    static int a = 0;

    int safeMethod(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13444().safeMethod(a));
    }
}
