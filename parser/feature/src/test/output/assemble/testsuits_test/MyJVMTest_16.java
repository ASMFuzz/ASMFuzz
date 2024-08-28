public class MyJVMTest_16 {

    static byte[] bytes = { 98, -19, 118, -21, 9, -83, 102, 10, 25, -90 };

    static String DIGITS = "0123456789abcdef";

    String hexDump(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        int i;
        buf.append("    ");
        for (i = 0; i < bytes.length; i++) {
            buf.append(DIGITS.charAt(bytes[i] >> 4 & 0x0f));
            buf.append(DIGITS.charAt(bytes[i] & 0x0f));
            if ((i + 1) % 32 == 0) {
                if (i + 1 != bytes.length) {
                    buf.append("\n    ");
                }
            } else if ((i + 1) % 4 == 0) {
                buf.append(' ');
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16().hexDump(bytes));
    }
}
