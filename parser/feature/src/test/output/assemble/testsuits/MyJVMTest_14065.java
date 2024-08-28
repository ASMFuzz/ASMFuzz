public class MyJVMTest_14065 {

    static int[] arr = { 8, 3, 5, 2, 7, 6, -1147707587, 9, 7, 2 };

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
        System.out.println(new MyJVMTest_14065().test2(arr));
    }
}
