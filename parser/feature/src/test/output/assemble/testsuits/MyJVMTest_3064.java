public class MyJVMTest_3064 {

    static byte[] bytes = { 7, -92, -56, -21, -76, 60, -2, -91, 47, 2 };

    static byte[] find = { -28, 71, -111, -38, 100, 24, -5, -90, -46, -92 };

    static byte[] replacement = { 121, 64, -70, -121, 89, -32, 38, 49, -2, 21 };

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
        new MyJVMTest_3064().replaceBytes(bytes, find, replacement);
    }
}
