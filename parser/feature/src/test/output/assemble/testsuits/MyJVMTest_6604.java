import java.util.stream.IntStream;

public class MyJVMTest_6604 {

    static int[] data = { 0, 8, 1, 9, 1, 0, 8, 1857684025, 9, -1962292978 };

    static int RANGE = 512;

    int[] test2(int[] data) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j] = data[j] + data[j + 1];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6604().test2(data);
    }
}
