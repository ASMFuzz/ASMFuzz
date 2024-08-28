import java.util.stream.IntStream;

public class MyJVMTest_3187 {

    static int[] data = { 9, -1396206548, -2053815316, 9, 0, 121671587, 1335700463, 2, 0, 4 };

    static int n = 1024;

    int[] test1(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = 0; i < n; i++) {
                data[j * n + i]++;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3187().test1(data);
    }
}
