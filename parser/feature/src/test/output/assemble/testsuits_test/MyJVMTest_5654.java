import java.lang.reflect.Constructor;

public class MyJVMTest_5654 {

    static byte[] bs = { 101, -99, 65, -89, 0, -62, 49, 6, 33, 28 };

    static Constructor<?> GHASH = null;

    static Method UPDATE = null;

    static Method DIGEST = null;

    static String HEX_DIGITS = "0123456789abcdef";

    String hex(byte[] bs) {
        StringBuilder sb = new StringBuilder(2 * bs.length);
        for (byte b : bs) {
            sb.append(HEX_DIGITS.charAt((b >> 4) & 0xF));
            sb.append(HEX_DIGITS.charAt(b & 0xF));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5654().hex(bs));
    }
}
