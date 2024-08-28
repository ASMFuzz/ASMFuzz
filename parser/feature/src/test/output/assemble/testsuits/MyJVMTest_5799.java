public class MyJVMTest_5799 {

    static double[][] A = { { Double.NaN, Double.MIN_VALUE, 0.6859826969565291, 0.9644312696793067, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.7838225905328265, 0.8721186529483441, Double.NaN }, { 0.827617217637223, Double.NEGATIVE_INFINITY, Double.NaN, 0.38218644055987283, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN } };

    static double[][] AA = { { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.961832508101726 }, { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY } };

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
        new MyJVMTest_5799().setSquare(A, AA);
    }
}
