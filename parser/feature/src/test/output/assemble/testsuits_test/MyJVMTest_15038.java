import java.util.stream.IntStream;

public class MyJVMTest_15038 {

    static int[] data = { 928200642, 1761411821, 0, -2145879030, 0, 0, 0, 7, 7, 825422738 };

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
        new MyJVMTest_15038().test3(data);
    }
}
