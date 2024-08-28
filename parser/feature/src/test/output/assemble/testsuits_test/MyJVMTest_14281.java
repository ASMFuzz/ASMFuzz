public class MyJVMTest_14281 {

    static long i = 9223372036854775807L;

    static int j = 7;

    static long k = 9223372036854775807L;

    long finMethod(long i, int j, long k) {
        long l = 30000L;
        while (true) {
            if (i == 123456789L)
                break;
            j += k * (l - i);
        }
        return;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14281().finMethod(i, j, k);
    }
}
