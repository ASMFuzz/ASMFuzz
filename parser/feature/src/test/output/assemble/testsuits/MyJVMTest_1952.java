public class MyJVMTest_1952 {

    static long[][] A = { { 0, 0, 0, 9223372036854775807L, -6033614027826850204L, 9223372036854775807L, -9223372036854775808L, 0, 0, 0 }, { 0, 9223372036854775807L, -6092442647580168237L, 0, -9223372036854775808L, 2938033307360636575L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L } };

    static long[][] AA = { { 1220193924967228867L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0, -8961381425728716214L }, { -9223372036854775808L, 0, 0, -8836658462840683308L, 9223372036854775807L, -9223372036854775808L, 0, -7880717355454685906L, -9223372036854775808L, 9223372036854775807L } };

    long[][] setSquare(long[][] A, long[][] AA) {
        if (A.length != A[0].length)
            throw new IllegalArgumentException("the argument matrix A should be square matrix");
        if (AA.length != AA[0].length)
            throw new IllegalArgumentException("the resulting matrix AA should be square matrix");
        if (A.length != AA.length)
            throw new IllegalArgumentException("the matrices A and AA should have equal size");
        int size = A.length;
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) {
            long sum = 0;
            for (int k = 0; k < size; k++) sum += A[line][k] * A[k][line];
            AA[line][column] = sum;
        }
        return A;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1952().setSquare(A, AA);
    }
}
