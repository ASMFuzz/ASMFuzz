import java.util.stream.IntStream;

public class MyJVMTest_1495 {

    static int[] data = { 8, 0, 2, 0, -118339926, 0, 2, 6, 2, 3 };

    static int A = 1;

    static int B = 0;

    static int RANGE = 512;

    int[] test3(int[] data, int A, int B) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j] = A * data[j] + B * data[j + 1];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1495().test3(data, A, B);
    }
}
