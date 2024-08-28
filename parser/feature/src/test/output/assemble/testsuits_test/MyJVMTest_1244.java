import java.util.stream.IntStream;

public class MyJVMTest_1244 {

    static int[] data = { 0, 1213350954, 0, 5, -541286699, 0, 0, 1293437330, 7, 0 };

    static int RANGE = 512;

    int[] test1(int[] data) {
        IntStream.range(0, RANGE).parallel().forEach(j -> {
            data[j] = j + 1;
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1244().test1(data);
    }
}
