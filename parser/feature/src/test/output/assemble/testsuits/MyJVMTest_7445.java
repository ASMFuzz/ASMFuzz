import java.util.Arrays;

public class MyJVMTest_7445 {

    static String in = "O\"6n_4e8k/";

    static String comment = "x-&J03}W[z";

    static String input = "'1]C*}+|P}";

    static String output = "W{!d<zLU-!";

    static String profile = "T,T~HkQ]nK";

    static int flags = 0;

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
        System.out.println(Arrays.asList(new MyJVMTest_7445().getBytes(in)));
    }
}
