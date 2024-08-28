public class MyJVMTest_10756 {

    static double[] data = { 0.26848546092062386, Double.MAX_VALUE, 0.11808740790237904, 0.006021842380802611, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0.36740946380617157, Double.NaN, Double.MAX_VALUE };

    static double[] gold = { 0.5014847858030185, Double.NEGATIVE_INFINITY, 0.3931589962555231, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, 0.03671463684554799, 0.8628865837396187 };

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
        new MyJVMTest_10756().verify(data, gold);
    }
}
