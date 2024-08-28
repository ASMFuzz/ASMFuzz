public class MyJVMTest_12946 {

    static int v = 6;

    static byte[] data = { -62, 19, 124, 0, -56, -22, 68, -113, 90, -97 };

    int getCommentPos(byte[] d) {
        int p = 8;
        while (p + 8 < d.length) {
            if (d[p + 4] == (byte) 0x74 && d[p + 5] == (byte) 0x45 && d[p + 6] == (byte) 0x58 && d[p + 7] == (byte) 0x74) {
                return p;
            }
            p++;
        }
        throw new RuntimeException("Test chunk was not found!");
    }

    int adjustCommentLength(int v, byte[] data) {
        final int pos = getCommentPos(data);
        data[pos + 3] = (byte) (v & 0xFF);
        v = v >> 8;
        data[pos + 2] = (byte) (v & 0xFF);
        v = v >> 8;
        data[pos + 1] = (byte) (v & 0xFF);
        v = v >> 8;
        data[pos + 0] = (byte) (v & 0xFF);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12946().adjustCommentLength(v, data);
    }
}
