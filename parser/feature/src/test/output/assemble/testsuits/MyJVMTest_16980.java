import java.util.Arrays;

public class MyJVMTest_16980 {

    static String in = "Z@W<,K<vDt";

    static String comment = "j<2&R~)<P~";

    static String input = "LP.?ur'-i{";

    static String output = "<\"^$7fLJOU";

    static String profile = "^@-d2/:8Z+";

    static int flags = 5;

    static Exception expected = null;

    byte[] getBytes(String in) {
        if (in == null) {
            return null;
        }
        byte[] bytes = new byte[in.length()];
        for (int i = 0; i < in.length(); i++) {
            bytes[i] = (byte) in.charAt(i);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16980().getBytes(in)));
    }
}
