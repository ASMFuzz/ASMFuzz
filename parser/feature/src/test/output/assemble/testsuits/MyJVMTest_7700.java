public class MyJVMTest_7700 {

    static float[][] A = { { Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE }, { Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE } };

    static float[][] AA = { { Float.MIN_VALUE, 0.2899977f, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.48747873f, 0f, Float.MAX_VALUE, Float.NaN }, { Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NaN } };

    float[][] setSquare(float[][] A, float[][] AA) {
        if (A.length != A[0].length)
            throw new IllegalArgumentException("the argument matrix A should be square matrix");
        if (AA.length != AA[0].length)
            throw new IllegalArgumentException("the resulting matrix AA should be square matrix");
        if (A.length != AA.length)
            throw new IllegalArgumentException("the matrices A and AA should have equal size");
        int size = A.length;
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) {
            float sum = 0;
            for (int k = 0; k < size; k++) sum += A[line][k] * A[k][line];
            AA[line][column] = sum;
        }
        return A;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7700().setSquare(A, AA);
    }
}
