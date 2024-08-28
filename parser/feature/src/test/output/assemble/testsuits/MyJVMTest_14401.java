public class MyJVMTest_14401 {

    static int i = 5;

    static int[] arr = { 5, 3, 1, 0, 0, 2, 0, 0, 0, -1559614360 };

    int test(int i, int[] arr) {
        if (i < 0 || i >= arr.length) {
        }
        arr[i] = 0x42;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14401().test(i, arr);
    }
}
