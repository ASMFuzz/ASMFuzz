public class MyJVMTest_7352 {

    static byte[] bytes = { 48, 58, 52, -18, 86, 108, -98, 11, -6, -82 };

    static int startIndex = -1189157851;

    static byte[] replacement = { 15, 39, 122, 58, 57, 111, -91, 86, 40, 117 };

    byte[] replace(byte[] bytes, int startIndex, byte[] replacement) {
        for (int index = 0; index < replacement.length; index++) {
            bytes[startIndex + index] = replacement[index];
        }
        return replacement;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7352().replace(bytes, startIndex, replacement);
    }
}
