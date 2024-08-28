public class MyJVMTest_4910 {

    static double[] sums = {0d,0.9892215866788815,0d,0.655852290843046,0.5535459481667152,Double.NaN,Double.NaN,Double.MAX_VALUE,Double.MAX_VALUE,0.270601319388563};

    double getSum() {
        double sum = 0;
        for (final double s : sums) {
            sum += s;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4910().getSum());
    }
}
