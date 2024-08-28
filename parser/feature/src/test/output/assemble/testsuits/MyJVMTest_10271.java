public class MyJVMTest_10271 {

    static int[][] A = { { 8, 0, 8, 1, 2, 4, 0, 0, 19124075, -1119278855 }, { 0, 3, 0, -1629752416, 1, 5, 52731196, 803680805, 2063691085, 1786271312 } };

    static int[][] AA = { { 0, 0, 1, 0, -411179083, 1, 0, 5, 9, 8 }, { 0, -1368758075, 5, 2, 7, -946726595, 0, 961037415, 0, 0 } };

    int[][] setSquare(int[][] A, int[][] AA) {
        if (A.length != A[0].length)
            throw new IllegalArgumentException("the argument matrix A should be square matrix");
        if (AA.length != AA[0].length)
            throw new IllegalArgumentException("the resulting matrix AA should be square matrix");
        if (A.length != AA.length)
            throw new IllegalArgumentException("the matrices A and AA should have equal size");
        int size = A.length;
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) {
            int sum = 0;
            for (int k = 0; k < size; k++) sum += A[line][k] * A[k][line];
            AA[line][column] = sum;
        }
        return A;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10271().setSquare(A, AA);
    }
}
