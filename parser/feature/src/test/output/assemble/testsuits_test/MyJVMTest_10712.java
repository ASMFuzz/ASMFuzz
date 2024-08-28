import java.util.stream.IntStream;

public class MyJVMTest_10712 {

    static int[] data = { 0, 1, 7, 0, 3, 4, 1156529672, 1, 1319237138, 5 };

    static int A = 0;

    static int B = 8;

    static int RANGE = 512;

    int[] test3(int[] data, int A, int B) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j] = A * data[j] + B * data[j + 1];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10712().test3(data, A, B);
    }
}
