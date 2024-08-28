import java.util.stream.IntStream;

public class MyJVMTest_10444 {

    static int[] data = { 2, -660753355, 0, 1, 1459171429, 1, 9, 0, 7, 7 };

    static int RANGE = 512;

    int[] test1(int[] data) {
        IntStream.range(0, RANGE).parallel().forEach(j -> {
            data[j] = j + 1;
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10444().test1(data);
    }
}
