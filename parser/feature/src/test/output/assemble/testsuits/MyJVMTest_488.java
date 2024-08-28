public class MyJVMTest_488 {

    static byte[] bytes = { 26, -89, 35, -72, -13, 88, 67, -2, -1, -103 };

    String getByteString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append("0x" + Integer.toHexString((int) (bytes[i] & 0xFF)) + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_488().getByteString(bytes));
    }
}
