import java.util.stream.IntStream;

public class MyJVMTest_4554 {

    static int[] data = { -24513280, 1, 0, 1, 0, 3, 7, 5, 0, -2082601928 };

    static int RANGE = 512;

    int[] test4(int[] data) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j + 1] = data[j];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4554().test4(data);
    }
}
