public class MyJVMTest_13896 {

    static int[] arr = { 0, 4, 0, 0, 8, -1395857703, -1560923995, 0, 2, 2 };

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
        System.out.println(new MyJVMTest_13896().test1(arr));
    }
}
