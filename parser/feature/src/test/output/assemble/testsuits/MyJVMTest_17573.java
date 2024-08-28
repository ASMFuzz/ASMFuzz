public class MyJVMTest_17573 {

    static byte[] block = { -96, -24, 32, -125, -122, -8, -64, -30, -115, 107 };

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
        System.out.println(new MyJVMTest_17573().toHexString(block));
    }
}
