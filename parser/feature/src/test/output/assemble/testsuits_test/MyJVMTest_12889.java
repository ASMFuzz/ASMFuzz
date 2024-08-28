import java.util.stream.IntStream;

public class MyJVMTest_12889 {

    static int[] data = { 1331988660, 0, 8, 8, 2, 9, 9, 7, 0, 5 };

    static int n = 1024;

    int[] test4(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = 0; i >= 1 - n; i--) {
                data[j * n - i]--;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12889().test4(data);
    }
}
