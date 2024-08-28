public class MyJVMTest_4881 {

    static long i = -1912592063792331238L;

    static int j = 3;

    static long k = 1444564473691010848L;

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
        new MyJVMTest_4881().finMethod(i, j, k);
    }
}
