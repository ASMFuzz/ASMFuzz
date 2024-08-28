import java.util.stream.IntStream;

public class MyJVMTest_13943 {

    static int[] data = { 5, 2, 0, 0, 9, 4, 337998700, 2, 0, 7 };

    static int RANGE = 512;

    int[] test4(int[] data) {
        IntStream.range(0, RANGE - 1).forEach(j -> {
            data[j + 1] = data[j];
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13943().test4(data);
    }
}
