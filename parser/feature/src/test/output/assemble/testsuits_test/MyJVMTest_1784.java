public class MyJVMTest_1784 {

    static int[] data = { -1273099817, 7, -182867912, 3, -1333158319, 8, 1589534630, 5, 4, 0 };

    static int k = 2;

    static int n = 1024;

    int verify(int[] data, int k) {
        for (int i = 0; i < n * n; i++) {
            if (data[i] != k) {
                throw new RuntimeException(" Invalid result: data[" + i + "]: " + data[i] + " != " + k);
            }
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1784().verify(data, k);
    }
}
