import java.util.Arrays;

public class MyJVMTest_1510 {

    static byte v = -97;

    static int length = 7;

    byte[] byteToByteArray(byte v, int length) {
        byte[] result = new byte[length];
        result[0] = v;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1510().byteToByteArray(v, length)));
    }
}
