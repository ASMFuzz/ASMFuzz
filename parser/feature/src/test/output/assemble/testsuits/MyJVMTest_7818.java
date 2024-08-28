public class MyJVMTest_7818 {

    static long a = 9223372036854775807L;

    long safeMethod(long a) {
        if (a == Long.MAX_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return a + 1L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7818().safeMethod(a));
    }
}
