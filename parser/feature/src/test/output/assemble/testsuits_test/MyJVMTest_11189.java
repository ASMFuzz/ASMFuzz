public class MyJVMTest_11189 {

    static long[][] A = { { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 4454238102491271204L, -9223372036854775808L, 3710264397628797950L, -7665542416032945647L }, { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, -8815907809066873613L, 0, 3169006236505866374L, 0, 0, 7199623593068042724L } };

    static long[][] AA = { { 9223372036854775807L, -9223372036854775808L, 395040567869463346L, 0, 2119961395624016509L, -9223372036854775808L, 8457400865331311475L, 0, -6256584382521904964L, 9223372036854775807L }, { -5905292698250395038L, 3578213432055944379L, 9223372036854775807L, 8387572765816285309L, 7193184711655564877L, -9223372036854775808L, 8047208786082199260L, 9223372036854775807L, -3297242395688972259L, 9223372036854775807L } };

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
        new MyJVMTest_11189().setSquare(A, AA);
    }
}
