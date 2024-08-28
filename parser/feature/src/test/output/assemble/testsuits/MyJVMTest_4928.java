import java.util.stream.IntStream;

public class MyJVMTest_4928 {

    static int[] data = { 4, 1961192751, 1, 9, 0, 5, -1588397295, 5, 6, 6 };

    static int n = 1024;

    int[] test5(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = 0; i < n / 2; i++) {
                data[j * n + (i << 1)]++;
            }
            for (int i = 0; i < n / 2; i++) {
                data[j * n + i * 2 + 1]++;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4928().test5(data);
    }
}
