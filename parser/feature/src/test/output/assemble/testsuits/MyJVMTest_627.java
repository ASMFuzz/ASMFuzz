import java.util.stream.IntStream;

public class MyJVMTest_627 {

    static double[] data = { Double.NEGATIVE_INFINITY, Double.NaN, 0.46720162475018745, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.MAX_VALUE };

    static int RANGE = 512;

    double[] init(double[] data) {
        IntStream.range(0, RANGE).parallel().forEach(j -> {
            data[j] = j + 1;
        });
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_627().init(data);
    }
}
