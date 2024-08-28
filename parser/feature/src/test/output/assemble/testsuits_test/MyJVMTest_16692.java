public class MyJVMTest_16692 {

    static long a = -3810084064657420801L;

    long safeMethod(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16692().safeMethod(a));
    }
}
