public class MyJVMTest_3686 {

    static long a = 7564815035134532481L;

    long safeMethod(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return a - 1L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3686().safeMethod(a));
    }
}
