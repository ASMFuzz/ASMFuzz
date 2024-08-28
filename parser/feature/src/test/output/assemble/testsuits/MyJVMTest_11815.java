import java.util.Arrays;

public class MyJVMTest_11815 {

    static int dataSize = 6;

    byte[] getTestArray_byte(int dataSize) {
        byte[] result = new byte[dataSize / 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) i;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11815().getTestArray_byte(dataSize)));
    }
}
