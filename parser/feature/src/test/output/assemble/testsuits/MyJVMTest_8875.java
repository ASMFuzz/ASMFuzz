public class MyJVMTest_8875 {

    static byte[] data = { -39, -3, -4, -111, -45, 67, -123, -99, -60, 115 };

    static int startIndex = 4;

    static int startOffset = 8;

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
        System.out.println(new MyJVMTest_8875().charsOffset(data, startIndex, startOffset));
    }
}
