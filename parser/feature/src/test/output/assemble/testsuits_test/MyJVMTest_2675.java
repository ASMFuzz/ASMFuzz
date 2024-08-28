import java.util.stream.IntStream;

public class MyJVMTest_2675 {

    static int[] data = { 4, 2069747925, 0, 0, 9, 5, 2, 0, 2, 7 };

    static int n = 1024;

    int[] test6(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = (n - 1) / 2; i >= 0; i--) {
                data[j * n + (i << 1)]--;
            }
            for (int i = (n - 1) / 2; i >= 0; i--) {
                data[j * n + i * 2 + 1]--;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2675().test6(data);
    }
}
