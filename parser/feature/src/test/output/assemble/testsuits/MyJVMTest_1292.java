public class MyJVMTest_1292 {

    static int idx = 1905680975;

    static long[] array = new long[10];

    int test_before_6(int idx) {
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 1) {
                res *= 2;
            } else {
                res++;
            }
            array[idx] = 999;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1292().test_before_6(idx));
    }
}
