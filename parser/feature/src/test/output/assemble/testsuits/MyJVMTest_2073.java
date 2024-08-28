public class MyJVMTest_2073 {

    static int idx = 0;

    static long[] array = new long[10];

    int test_before_3(int idx) {
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            res += array[i % 10];
            array[idx] = 999;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2073().test_before_3(idx));
    }
}
