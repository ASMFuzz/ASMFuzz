import java.util.Arrays;

public class MyJVMTest_9230 {

    static String s = "~VBCU#<~vp";

    static byte[] message = {7,0,122,66,45,-123,-41,-2,30,82};

    static int id = 3;

    static String name = ">ud6=4!Hk6";

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
        System.out.println(Arrays.asList(new MyJVMTest_9230().parseHexBinary(s)));
    }
}
