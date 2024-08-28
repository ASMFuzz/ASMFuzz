public class MyJVMTest_11680 {

    static long one = 9223372036854775807L;

    static long two = 0;

    long test(long one, long two) {
        while (true) {
            if (one >= two) {
                break;
            }
        }
        return two;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11680().test(one, two);
    }
}
