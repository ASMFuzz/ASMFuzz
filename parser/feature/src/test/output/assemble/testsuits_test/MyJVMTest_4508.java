public class MyJVMTest_4508 {

    static int[] arr = { 8, 0, 3, 0, 0, 1, 6, -469810803, 1, 0 };

    int test1(int[] arr) {
        int j = 0;
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (; j != 5; j++) {
                if (j >= 20) {
                    break;
                }
                res += arr[j];
            }
            j = 10;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4508().test1(arr));
    }
}
