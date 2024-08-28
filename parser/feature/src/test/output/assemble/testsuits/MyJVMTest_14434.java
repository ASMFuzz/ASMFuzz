public class MyJVMTest_14434 {

    static int[] a = { 1745437568, 3, 6, -1415564366, 0, -909953599, -466879204, 6, 8, 253564439 };

    static double[] b = { 0.05024485259433531, Double.MAX_VALUE, 0.48263272165438, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0d, Double.MAX_VALUE, 0d };

    static int c = 5;

    static double d = 0.28290749785428637;

    int[] test_vi_oppos(int[] a, double[] b, int c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14434().test_vi_oppos(a, b, c, d);
    }
}
