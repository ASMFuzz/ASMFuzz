import java.util.stream.IntStream;

public class MyJVMTest_5602 {

    static int[] data = { -1283830796, -1809038471, 5, -635725727, 0, 0, 0, 526905053, 5, 9 };

    static int n = 1024;

    int[] test3(int[] data) {
        IntStream.range(0, n).forEach(j -> {
            for (int i = 1 - n; i < 1; i++) {
                data[j * n - i]++;
            }
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5602().test3(data);
    }
}
