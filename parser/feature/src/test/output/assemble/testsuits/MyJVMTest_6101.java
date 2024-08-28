public class MyJVMTest_6101 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, 0.8989097271165307, 0d, 0.06578677830219903, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY };

    double summ2(double[] a) {
        Double result1 = 1.;
        Double result2 = new Double(1.);
        for (Double i : a) {
            result1 += i;
            result2 += new Double(i + 1.);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6101().summ2(a));
    }
}
