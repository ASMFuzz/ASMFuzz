public class MyJVMTest_2413 {

    static long one = 0;

    static long two = -9223372036854775808L;

    long test(long one, long two) {
        while (true) {
            if (one >= two) {
                break;
            }
        }
        return two;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2413().test(one, two);
    }
}
