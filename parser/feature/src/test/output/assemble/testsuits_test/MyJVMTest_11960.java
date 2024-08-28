import java.util.stream.IntStream;

public class MyJVMTest_11960 {

    static int[] data = { 0, 3, 8, 0, 0, 4, 7, 8, 7, 1805319736 };

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
        new MyJVMTest_11960().test6(data);
    }
}
