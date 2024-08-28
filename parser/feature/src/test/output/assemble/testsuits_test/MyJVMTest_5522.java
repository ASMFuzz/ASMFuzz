import java.util.Arrays;

public class MyJVMTest_5522 {

    static int[][] intA = { { 0, 7, 4, 0, 1621669402, 7, -234103486, 2136069149, 1084005481, 0 }, { 0, 2, 5, -302915540, 0, 0, 1274057319, 3, 4, 0 } };

    long[][] newLongMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        long[][] longA = new long[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) longA[line][column] = intA[line][column];
        return longA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5522().newLongMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_5522().newLongMatrix(intA)[1]));
    }
}
