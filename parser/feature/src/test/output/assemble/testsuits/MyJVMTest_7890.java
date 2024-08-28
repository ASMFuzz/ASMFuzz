import java.util.stream.IntStream;

public class MyJVMTest_7890 {

    static int[] data = { 583696313, 2, 0, 0, 0, 8, 3, 9, 8, 1195559217 };

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
        new MyJVMTest_7890().test2(data);
    }
}
