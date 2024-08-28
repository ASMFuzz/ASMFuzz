public class MyJVMTest_1077 {

    static int[][] A = { { 0, 6, 3, 0, 0, 7, 0, 8, 3, 7 }, { -1915282055, -1123053433, 6, 0, 2, 4, 3, 9, 0, -173456268 } };

    static int[][] AA = { { 5, 362361652, -208430879, 4, 8, 2, 0, 9, 57013660, 2 }, { 0, -682762868, 2, 0, 528520156, 2, 1, 0, 0, 9 } };

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
        new MyJVMTest_1077().setSquare(A, AA);
    }
}
