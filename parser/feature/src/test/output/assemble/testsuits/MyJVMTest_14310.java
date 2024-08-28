public class MyJVMTest_14310 {

    static double[] sums = {Double.NEGATIVE_INFINITY,0.4478175060944435,Double.MIN_VALUE,0d,Double.POSITIVE_INFINITY,Double.MIN_VALUE,0d,Double.NaN,Double.MAX_VALUE,0d};

    double getSum() {
        double sum = 0;
        for (final double s : sums) {
            sum += s;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14310().getSum());
    }
}
