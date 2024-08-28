import java.util.Arrays;

public class MyJVMTest_10727 {

    static byte v = -42;

    static int length = 1603044558;

    byte[] byteToByteArray(byte v, int length) {
        byte[] result = new byte[length];
        result[0] = v;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10727().byteToByteArray(v, length)));
    }
}
