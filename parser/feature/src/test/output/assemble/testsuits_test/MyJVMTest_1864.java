public class MyJVMTest_1864 {

    static double[] a = { Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0.7610661499546428, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.7484439953748871, 0.7178824963609886, 0d, 0.4632892821714161, 0.44121044517874775, Double.NaN, 0.5889085611745508, Double.MAX_VALUE };

    static double[] c = { Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MAX_VALUE };

    static double[] d = { Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.35240828634371835, Double.POSITIVE_INFINITY, 0.9975679002020176, Double.NEGATIVE_INFINITY, 0.6275733224820844 };

    static double total = 0d;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.sqrt(a[i] * b[i]) + Math.sqrt(a[i] * c[i]) + Math.sqrt(b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1864().sumReductionImplement(a, b, c, d, total));
    }
}
