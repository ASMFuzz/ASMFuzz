public class MyJVMTest_6776 {

    static double logSummand = Double.MIN_VALUE;

    static double[] logSummandArray = {Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.MIN_VALUE,0.6305395736570636,Double.NEGATIVE_INFINITY,0.6824033218027236,Double.NEGATIVE_INFINITY,0.2900998672552797,0d};

    static int currSize = 0;

    static double maxLogSummand = 0d;

    double addLogSummand(double logSummand) {
        logSummandArray[currSize] = logSummand;
        currSize++;
        maxLogSummand = Math.max(maxLogSummand, logSummand);
        return logSummand;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6776().addLogSummand(logSummand);
    }
}
