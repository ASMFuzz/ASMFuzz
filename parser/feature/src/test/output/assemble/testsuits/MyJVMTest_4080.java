import java.util.Arrays;

public class MyJVMTest_4080 {

    static String hex = "wvmy^y ot@";

    static String testName = "/,G;Y\\1<sL";

    static String algName = "w\"F-V&5A8w";

    static byte[] IKM = {-32,24,101,-98,-45,51,-38,103,-28,78};

    static byte[] salt = {-32,-16,28,-110,-39,18,-92,-9,54,11};

    static byte[] info = {-52,-97,121,79,-60,-115,-79,39,-4,42};

    static int outLen = 0;

    static byte[] expectedPRK = {53,90,-120,114,-53,58,-87,-43,-38,89};

    static byte[] expectedOKM = {-56,92,67,17,71,95,-81,-102,97,16};

    byte[] hex2bin(String hex) {
        int i;
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4080().hex2bin(hex)));
    }
}
