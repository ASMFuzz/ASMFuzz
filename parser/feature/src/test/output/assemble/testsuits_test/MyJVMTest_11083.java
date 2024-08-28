public class MyJVMTest_11083 {

    static int[] a1 = { 0, 9, -1394556312, 0, 9, 3, -1474496880, 0, 3, 0 };

    int test_sum(int[] a1) {
        int sum = 0;
        for (int i = 0; i < a1.length; i += 1) {
            sum += a1[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11083().test_sum(a1));
    }
}
