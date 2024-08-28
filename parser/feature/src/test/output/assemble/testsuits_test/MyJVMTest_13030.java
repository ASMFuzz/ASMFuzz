public class MyJVMTest_13030 {

    static byte[] d = { -84, -93, -23, -106, -74, -100, 116, -23, 37, -72 };

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13030().getCommentPos(d));
    }
}
