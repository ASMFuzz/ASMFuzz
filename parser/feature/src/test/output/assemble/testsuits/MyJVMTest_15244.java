public class MyJVMTest_15244 {

    static double[][] A = { { Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY }, { Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, 0d } };

    static double[][] AA = { { Double.POSITIVE_INFINITY, 0.752852092996893, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, 0.2958373006088194, Double.NEGATIVE_INFINITY }, { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY } };

    double[][] setSquare(double[][] A, double[][] AA) {
        if (A.length != A[0].length)
            throw new IllegalArgumentException("the argument matrix A should be square matrix");
        if (AA.length != AA[0].length)
            throw new IllegalArgumentException("the resulting matrix AA should be square matrix");
        if (A.length != AA.length)
            throw new IllegalArgumentException("the matrices A and AA should have equal size");
        int size = A.length;
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) {
            double sum = 0;
            for (int k = 0; k < size; k++) sum += A[line][k] * A[k][line];
            AA[line][column] = sum;
        }
        return A;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15244().setSquare(A, AA);
    }
}
