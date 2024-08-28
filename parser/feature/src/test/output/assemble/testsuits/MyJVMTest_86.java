import java.util.Arrays;

public class MyJVMTest_86 {

    static String s = "WHzOu!&=-A";

    static byte[] message = {121,-121,-41,-68,-62,-45,-126,110,104,42};

    static int id = -1676538697;

    static String name = "/53.[+bgm/";

    byte[] parseHexBinary(String s) {
        final int len = s.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + s);
        }
        byte[] out = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            int h = Character.digit(s.charAt(i), 16);
            int l = Character.digit(s.charAt(i + 1), 16);
            if (h == -1 || l == -1) {
                throw new IllegalArgumentException("contains illegal character for hexBinary: " + s);
            }
            out[i / 2] = (byte) (h * 16 + l);
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_86().parseHexBinary(s)));
    }
}
