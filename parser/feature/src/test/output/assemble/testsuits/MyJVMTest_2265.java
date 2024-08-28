import java.util.Arrays;

public class MyJVMTest_2265 {

    static int[][] intA = { { 6, 0, 6, 404066819, 0, 9, 1582719920, 6, 2, 2 }, { 0, 2, 9, 102398890, 0, 9, 6, 8, 0, 6 } };

    double[][] newDoubleMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        double[][] doubleA = new double[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) doubleA[line][column] = intA[line][column];
        return doubleA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2265().newDoubleMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_2265().newDoubleMatrix(intA)[1]));
    }
}
