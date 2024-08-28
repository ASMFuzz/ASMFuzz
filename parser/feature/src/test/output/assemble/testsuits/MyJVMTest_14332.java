import java.util.stream.IntStream;

public class MyJVMTest_14332 {

    static int[] data = { 8, 5, 2, 1, 5, 0, 0, 0, 0, 1929672961 };

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
        new MyJVMTest_14332().test5(data);
    }
}
