import java.util.stream.IntStream;

public class MyJVMTest_3555 {

    static int[] data = { 6, 0, 1493562123, 8, 0, 0, 585299660, -1488486943, 6, 0 };

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
        new MyJVMTest_3555().test4(data);
    }
}
