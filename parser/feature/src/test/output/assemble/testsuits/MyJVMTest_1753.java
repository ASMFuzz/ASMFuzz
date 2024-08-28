import java.util.Arrays;

public class MyJVMTest_1753 {

    static int length = 507984074;

    static byte[] SALT = {-91,55,-5,8,-1,-67,116,48,-71,60};

    static byte[] PLAIN_TEXT = {0,-50,111,32,-112,-126,35,76,59,25};

    byte[] generateBytes(int length) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (i & 0xff);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1753().generateBytes(length)));
    }
}
