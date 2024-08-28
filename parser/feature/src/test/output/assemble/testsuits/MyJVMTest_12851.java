public class MyJVMTest_12851 {

    static byte[] data = { -77, 13, 77, 18, 69, 30, 112, 81, -65, 73 };

    static int startIndex = 0;

    static int startOffset = 228216639;

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
        System.out.println(new MyJVMTest_12851().charsOffset(data, startIndex, startOffset));
    }
}
