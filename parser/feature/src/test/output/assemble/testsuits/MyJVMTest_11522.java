import java.util.Arrays;

public class MyJVMTest_11522 {

    static int[][] intA = { { 0, 5, 7, 164085474, 0, 5, 0, -1418750911, 5, 1230513800 }, { 6, 4, 9, 1334420836, -1630767713, 3, 381244441, 3, 0, 0 } };

    double[][] newDoubleMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        double[][] doubleA = new double[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) doubleA[line][column] = intA[line][column];
        return doubleA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11522().newDoubleMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_11522().newDoubleMatrix(intA)[1]));
    }
}
