import java.lang.reflect.Constructor;

public class MyJVMTest_15090 {

    static byte[] bs = { -61, -37, -104, -38, 5, -103, 119, 48, -42, 3 };

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
        System.out.println(new MyJVMTest_15090().hex(bs));
    }
}
