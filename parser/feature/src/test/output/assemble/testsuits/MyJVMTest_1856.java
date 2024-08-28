public class MyJVMTest_1856 {

    static int[] a1 = { -1098561987, 2, 8, 2094481337, 2, -37195316, -329571535, 0, 7, 4 };

    int test_sum(int[] a1) {
        int sum = 0;
        for (int i = 0; i < a1.length; i += 1) {
            sum += a1[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1856().test_sum(a1));
    }
}
