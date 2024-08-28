public class MyJVMTest_8054 {

    static double[] logSummandArray = {0d,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,Double.MIN_VALUE,Double.NaN,Double.NaN,Double.MAX_VALUE,Double.MAX_VALUE,0d};

    static int currSize = 0;

    static double maxLogSummand = Double.POSITIVE_INFINITY;

    double retrieveLogSum() {
        if (maxLogSummand == Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        assert currSize <= logSummandArray.length;
        double factorSum = 0;
        for (int i = 0; i < currSize; i++) {
            factorSum += Math.exp(logSummandArray[i] - maxLogSummand);
        }
        return Math.log(factorSum) + maxLogSummand;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8054().retrieveLogSum());
    }
}
