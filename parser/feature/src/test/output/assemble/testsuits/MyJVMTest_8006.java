public class MyJVMTest_8006 {

    static byte[] block = { 121, 74, -63, 59, -44, -112, -110, -63, 26, 1 };

    String toHexString(byte[] block) {
        StringBuilder buf = new StringBuilder();
        int len = block.length;
        for (int i = 0; i < len; i++) {
            buf.append(String.format("%02X", block[i]));
            if (i < len - 1) {
                buf.append(":");
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8006().toHexString(block));
    }
}
