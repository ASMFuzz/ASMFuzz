public class MyJVMTest_3517 {

    static byte[] data = { -20, -71, 46, -73, 109, -18, 105, 11, -98, 65 };

    static int startIndex = 3;

    static int startOffset = 2;

    int charsOffset(byte[] data, int startIndex, int startOffset) {
        int offset = startOffset;
        while (startIndex + ++offset < data.length) {
            byte datum = data[startIndex + offset];
            if (datum < 32 || datum > 126) {
                break;
            }
        }
        return offset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3517().charsOffset(data, startIndex, startOffset));
    }
}
