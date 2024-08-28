public class MyJVMTest_13023 {

    static long a = -9223372036854775808L;

    long safeMethod(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return a - 1L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13023().safeMethod(a));
    }
}
