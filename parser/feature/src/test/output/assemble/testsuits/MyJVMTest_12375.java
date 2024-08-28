public class MyJVMTest_12375 {

    static byte[] bytes = { 17, 104, -35, 20, -62, 58, -82, -101, 81, -100 };

    static byte[] find = { -20, -35, 96, -47, -24, -15, 64, 8, 34, -105 };

    static byte[] replacement = { 61, -27, 29, 106, -7, -13, 79, -67, 70, -51 };

    boolean matches(byte[] bytes, int startIndex, byte[] matching) {
        for (int i = 0; i < matching.length; i++) {
            if (bytes[startIndex + i] != matching[i]) {
                return false;
            }
        }
        return true;
    }

    void replace(byte[] bytes, int startIndex, byte[] replacement) {
        for (int index = 0; index < replacement.length; index++) {
            bytes[startIndex + index] = replacement[index];
        }
    }

    byte[] replaceBytes(byte[] bytes, byte[] find, byte[] replacement) {
        for (int index = 0; index < bytes.length - find.length; index++) {
            if (matches(bytes, index, find)) {
                replace(bytes, index, replacement);
            }
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12375().replaceBytes(bytes, find, replacement);
    }
}
