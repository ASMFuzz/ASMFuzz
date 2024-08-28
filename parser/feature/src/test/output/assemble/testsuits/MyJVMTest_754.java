public class MyJVMTest_754 {

    static int i = 7;

    static int limit = -703204276;

    static int[] arr = { 0, 48453233, 0, 2, 1, 763358805, 2, 1344584885, 4, 9 };

    int test4(int i, int limit, int[] arr) {
        while (i-- != 0) {
            if (arr[arr.length + i + 1] <= limit)
                break;
            arr[arr.length + i] = i * 2;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_754().test4(i, limit, arr);
    }
}
