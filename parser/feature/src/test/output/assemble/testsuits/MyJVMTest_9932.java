public class MyJVMTest_9932 {

    static int i = 0;

    static int limit = 6;

    static int[] arr = { 9, 1, 5, 1253113771, 4, 0, 1, 9, -419684260, 0 };

    int test4(int i, int limit, int[] arr) {
        while (i-- != 0) {
            if (arr[arr.length + i + 1] <= limit)
                break;
            arr[arr.length + i] = i * 2;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9932().test4(i, limit, arr);
    }
}
