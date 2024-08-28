public class MyJVMTest_17623 {

    static double[] logSummandArray = {Double.NaN,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NaN,Double.MAX_VALUE,0.5629524273074991,0d,Double.NaN};

    static int currSize = 0;

    static double maxLogSummand = 0d;

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
        System.out.println(new MyJVMTest_17623().retrieveLogSum());
    }
}
