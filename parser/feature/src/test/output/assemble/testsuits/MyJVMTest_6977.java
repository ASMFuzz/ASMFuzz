public class MyJVMTest_6977 {

    static long[] a = { 0, -343963780096496732L, -5631522316692913281L, 5472332835394093580L, 4649489339265698885L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -6350098404525804683L };

    static long b = 0;

    long[] check(long[] a) {
        for (int j = 0; j < 20; j++) {
            if (j >= 2 && j <= 6) {
                if (a[j] != 132) {
                    throw new RuntimeException("expected 132 at index " + j + " but got " + a[j]);
                }
            } else if (a[j] != 0) {
                throw new RuntimeException("expected 0 at index " + j + " but got " + a[j]);
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6977().check(a);
    }
}
