import java.util.Arrays;

public class MyJVMTest_12086 {

    static int size = 1;

    double[][] newMatrix(int size) {
        if ((size < 1) || (size > 1000))
            throw new IllegalArgumentException("matrix size should be 1 to 1000");
        double[][] A = new double[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) A[line][column] = (1 - 2 * Math.random()) * size;
        return A;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12086().newMatrix(size)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_12086().newMatrix(size)[1]));
    }
}
