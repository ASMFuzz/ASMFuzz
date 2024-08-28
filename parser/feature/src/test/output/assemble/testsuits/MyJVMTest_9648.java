public class MyJVMTest_9648 {

    static byte[] bytes = { 10, -110, 85, 54, -53, -7, -86, -2, -100, -11 };

    String getByteString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append("0x" + Integer.toHexString((int) (bytes[i] & 0xFF)) + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9648().getByteString(bytes));
    }
}
