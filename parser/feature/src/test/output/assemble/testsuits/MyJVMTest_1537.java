public class MyJVMTest_1537 {

    static double[] data = { Double.NaN, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.7305019983799809, 0.2647397192162948, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    static double[] gold = { Double.NaN, Double.NEGATIVE_INFINITY, 0.4554782849411697, Double.MIN_VALUE, 0.6763719409567873, 0d, 0.16918618191426682, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE };

    static int RANGE = 512;

    double[] verify(double[] data, double[] gold) {
        for (int i = 0; i < RANGE; i++) {
            if (data[i] != gold[i]) {
                throw new RuntimeException(" Invalid result: data[" + i + "]: " + data[i] + " != " + gold[i]);
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1537().verify(data, gold);
    }
}
