import java.util.Arrays;

public class MyJVMTest_2540 {

    static int dataSize = -1551234744;

    byte[] getTestArray_byte(int dataSize) {
        byte[] result = new byte[dataSize / 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2540().getTestArray_byte(dataSize)));
    }
}
