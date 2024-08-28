import java.lang.reflect.Constructor;
import java.util.Arrays;

public class MyJVMTest_15436 {

    static String hex = "++irGX9'e`";

    static Constructor<?> GHASH = null;

    static Method UPDATE = null;

    static Method DIGEST = null;

    static String HEX_DIGITS = "0123456789abcdef";

    byte[] bytes(String hex) {
        if ((hex.length() & 1) != 0) {
            throw new AssertionError();
        }
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < result.length; ++i) {
            int a = HEX_DIGITS.indexOf(hex.charAt(2 * i));
            int b = HEX_DIGITS.indexOf(hex.charAt(2 * i + 1));
            if ((a | b) < 0) {
                if (a < 0) {
                    throw new AssertionError("bad character " + (int) hex.charAt(2 * i));
                }
                throw new AssertionError("bad character " + (int) hex.charAt(2 * i + 1));
            }
            result[i] = (byte) ((a << 4) | b);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15436().bytes(hex)));
    }
}
