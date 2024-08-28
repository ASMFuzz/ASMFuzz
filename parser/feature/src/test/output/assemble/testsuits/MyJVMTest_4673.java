public class MyJVMTest_4673 {

    static int[] arr = { 778236397, 4, 7, 3, 3, 0, -626311295, 2, 8, 6 };

    int test2(int[] arr) {
        int j = 10;
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (; j != 5; j--) {
                if (j < 0) {
                    break;
                }
                res += arr[j];
            }
            j = 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4673().test2(arr));
    }
}
