public class MyJVMTest_494 {

    static int i = 2035313660;

    static int limit = 2;

    static int[] arr = { 0, 0, 853082204, 0, 0, 819948271, 0, 0, 0, -1407918131 };

    int test3(int i, int limit, int[] arr) {
        while (i++ != 0) {
            if (arr[i - 1] >= limit)
                break;
            arr[i] = i * 2;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_494().test3(i, limit, arr);
    }
}
