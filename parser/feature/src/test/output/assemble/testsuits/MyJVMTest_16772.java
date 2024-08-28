public class MyJVMTest_16772 {

    static byte[] needle = { -32, 30, 44, 29, -73, 97, -76, -107, 126, -61 };

    static byte[] haystack = { -3, -16, -42, 82, -34, 102, -109, -54, -38, 88 };

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
        System.out.println(new MyJVMTest_16772().findBytes(needle, haystack));
    }
}
