public class MyJVMTest_7249 {

    static byte[] needle = { -85, -72, -34, 24, -14, -56, -113, 114, -55, -109 };

    static byte[] haystack = { 2, 54, 76, -66, 27, 16, -40, 104, -18, -14 };

    int findBytes(byte[] needle, byte[] haystack) {
        HAYSTACK: for (int h = 0; h <= haystack.length - needle.length; ++h) {
            for (int n = 0; n < needle.length; ++n) {
                if (needle[n] != haystack[h + n]) {
                    continue HAYSTACK;
                }
            }
            return h;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7249().findBytes(needle, haystack));
    }
}
