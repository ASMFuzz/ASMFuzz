public class MyJVMTest_7169 {

    static long a = 1803826212653070156L;

    long safeMethod(long a) {
        if (a == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7169().safeMethod(a));
    }
}
