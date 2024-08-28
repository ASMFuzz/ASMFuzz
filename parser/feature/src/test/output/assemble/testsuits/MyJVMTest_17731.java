import java.util.Arrays;

public class MyJVMTest_17731 {

    static int[][] intA = { { 4, 0, 280277130, 0, 0, 0, 1, 664658675, 8, -1928157030 }, { 4, 2, 1655042431, 6, 1713327395, -1463546467, 5, -1674037596, 1893160852, 8 } };

    float[][] newFloatMatrix(int[][] intA) {
        if (intA.length != intA[0].length)
            throw new IllegalArgumentException("need square argument matrix");
        int size = intA.length;
        float[][] floatA = new float[size][size];
        for (int line = 0; line < size; line++) for (int column = 0; column < size; column++) floatA[line][column] = intA[line][column];
        return floatA;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17731().newFloatMatrix(intA)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_17731().newFloatMatrix(intA)[1]));
    }
}
