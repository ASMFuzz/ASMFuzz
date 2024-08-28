public class MyJVMTest_4994 {

    static int i = 5;

    static int[] arr = { 6, -1735530448, 8, 2, 0, 1300096781, 0, 9, 504421421, 0 };

    int test(int i, int[] arr) {
        if (i < 0 || i >= arr.length) {
        }
        arr[i] = 0x42;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4994().test(i, arr);
    }
}
