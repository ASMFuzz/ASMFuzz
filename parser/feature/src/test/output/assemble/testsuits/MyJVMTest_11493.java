import java.io.ByteArrayOutputStream;

public class MyJVMTest_11493 {

    static String enc = "$gBGM$O6Nh";

    static int byteOrder = -534935409;

    static boolean markit = true;

    static int BOM_HIGH = 0xfe;

    static int BOM_LOW = 0xff;

    static int BIG = 0;

    static int LITTLE = 1;

    ByteArrayOutputStream decode(String enc, int byteOrder, boolean markit) throws Exception {
        String s = "abc";
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        if (markit) {
            if (byteOrder == BIG) {
                bo.write(BOM_HIGH);
                bo.write(BOM_LOW);
            } else if (byteOrder == LITTLE) {
                bo.write(BOM_LOW);
                bo.write(BOM_HIGH);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (byteOrder == BIG) {
                bo.write(c >> 8);
                bo.write(c & 0xff);
            } else if (byteOrder == LITTLE) {
                bo.write(c & 0xff);
                bo.write(c >> 8);
            }
        }
        byte[] b = bo.toByteArray();
        String s2 = new String(b, enc);
        if (!s.equals(s2))
            throw new Exception(enc + ": Decode error");
        return bo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11493().decode(enc, byteOrder, markit);
    }
}
