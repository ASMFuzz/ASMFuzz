public class MyJVMTest_7389 {

    static int a = 2;

    int safeMethod(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return a - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7389().safeMethod(a));
    }
}
