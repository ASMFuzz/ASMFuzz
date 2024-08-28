import java.util.stream.IntStream;

public class MyJVMTest_16100 {

    static int[] data = { 0, 348754382, 0, 0, 1684998645, 2, -2105755957, 3, 5, 0 };

    static int RANGE = 512;

    int[] test2(int[] data) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j] = data[j] + data[j + 1];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16100().test2(data);
    }
}
