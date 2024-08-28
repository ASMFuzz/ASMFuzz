import java.util.Arrays;

public class MyJVMTest_14955 {

    static int[][] intA = { { 1354949688, 4, 0, 1, 0, 1262991713, 604459894, 0, 2, -2087501272 }, { 0, 0, 259231063, 6, 1837337506, 4, 0, 0, -1076991346, 4 } };

    long[][] newLongMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        long[][] longA = new long[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) longA[line][column] = intA[line][column];
        return longA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14955().newLongMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_14955().newLongMatrix(intA)[1]));
    }
}
