public class MyJVMTest_16273 {

    static double logSummand = Double.MAX_VALUE;

    static double[] logSummandArray = {Double.MIN_VALUE,Double.MIN_VALUE,0d,Double.MAX_VALUE,Double.NaN,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,0.10098301913957597,Double.MAX_VALUE,Double.MIN_VALUE};

    static int currSize = 4;

    static double maxLogSummand = Double.NEGATIVE_INFINITY;

    double addLogSummand(double logSummand) {
        logSummandArray[currSize] = logSummand;
        currSize++;
        maxLogSummand = Math.max(maxLogSummand, logSummand);
        return logSummand;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16273().addLogSummand(logSummand);
    }
}
