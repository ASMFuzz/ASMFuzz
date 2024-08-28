import java.util.stream.IntStream;

public class MyJVMTest_12504 {

    static int[] data = { 0, 0, 0, 8, 0, 5, -855344036, -78583634, -1399611022, 0 };

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
        new MyJVMTest_12504().test1(data);
    }
}
