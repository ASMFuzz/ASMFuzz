import java.util.stream.IntStream;

public class MyJVMTest_9794 {

    static double[] data = { 0.5029065482829712, Double.NaN, 0.4901443159516401, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.12355243454197096, 0.48887682582135716, Double.POSITIVE_INFINITY };

    static int RANGE = 512;

    double[] init(double[] data) {
        IntStream.range(0, RANGE).parallel().forEach(j -> {
            data[j] = j + 1;
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9794().init(data);
    }
}
