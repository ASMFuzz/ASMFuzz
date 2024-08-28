public class MyJVMTest_9655 {

    static int i = 0;

    static int limit = 626480020;

    static int[] arr = { 1, 7, 1717619365, -849380036, 8, 8, 0, 0, 8, 0 };

    int test3(int i, int limit, int[] arr) {
        while (i++ != 0) {
            if (arr[i - 1] >= limit)
                break;
            arr[i] = i * 2;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9655().test3(i, limit, arr);
    }
}
