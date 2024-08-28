public class MyJVMTest_5403 {

    static byte[] bytes = { -110, 42, -40, -87, 122, -87, 70, 122, -72, 36 };

    static int index = 4;

    static String DIGITS = "0123456789abcdef";

    String hexDump(byte[] bytes, int index) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        int i;
        buf.append("    ");
        buf.append(DIGITS.charAt(bytes[index] >> 4 & 0x0f));
        buf.append(DIGITS.charAt(bytes[index] & 0x0f));
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5403().hexDump(bytes, index));
    }
}
