public class MyJVMTest_11008 {

    static int[] data = { 8283405, 1375410246, 5, 0, 0, 875369266, 0, 0, 6, -90061329 };

    static int k = 0;

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
        new MyJVMTest_11008().verify(data, k);
    }
}
