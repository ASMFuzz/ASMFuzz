public class MyJVMTest_16881 {

    static byte[] bytes = { -84, 60, 61, -32, 69, 71, 29, -47, -86, 7 };

    static int startIndex = 0;

    static byte[] replacement = { -26, 66, -113, 63, -102, 51, -56, -63, -107, 65 };

    byte[] replace(byte[] bytes, int startIndex, byte[] replacement) {
        for (int index = 0; index < replacement.length; index++) {
            bytes[startIndex + index] = replacement[index];
        }
        return replacement;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16881().replace(bytes, startIndex, replacement);
    }
}
