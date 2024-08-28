public class MyJVMTest_14828 {

    static byte[] bytes = { 11, 46, -17, 105, -94, 125, 111, 37, -125, 41 };

    static int index = 0;

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
        System.out.println(new MyJVMTest_14828().hexDump(bytes, index));
    }
}
