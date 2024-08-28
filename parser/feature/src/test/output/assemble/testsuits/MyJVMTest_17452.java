import java.util.stream.IntStream;

public class MyJVMTest_17452 {

    static int[] data = { -128879832, 1, 3, 0, 1222757915, 0, 768804205, 2, 1940772538, 0 };

    static int n = 1024;

    int[] test2(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = n - 1; i >= 0; i--) {
                data[j * n + i]--;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17452().test2(data);
    }
}
