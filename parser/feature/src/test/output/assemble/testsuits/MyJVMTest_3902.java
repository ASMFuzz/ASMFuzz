import java.util.Arrays;

public class MyJVMTest_3902 {

    static int dataSize = 0;

    int[] getTestArray_int(int dataSize) {
        int[] result = new int[dataSize / 4];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3902().getTestArray_int(dataSize)));
    }
}
