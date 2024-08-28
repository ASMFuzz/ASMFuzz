import java.util.Arrays;

public class MyJVMTest_8158 {

    static int[][] intA = { { 8, -1646229216, -725999446, 9, -1142595965, 1, -47957862, 2, -975076153, 0 }, { 8, 0, 1, 0, 1180173979, 8, 7, 0, 6, 2 } };

    float[][] newFloatMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        float[][] floatA = new float[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) floatA[line][column] = intA[line][column];
        return floatA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8158().newFloatMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_8158().newFloatMatrix(intA)[1]));
    }
}
