import java.util.Arrays;

public class MyJVMTest_5775 {

    static int length = 7;

    byte[] generateBytes(int length) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (i & 0xff);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5775().generateBytes(length)));
    }
}
