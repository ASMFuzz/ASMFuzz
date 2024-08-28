public class MyJVMTest_9163 {

    static byte[] data = { 118, -23, 13, 39, -92, 57, 99, 11, 58, -14 };

    static int startIndex = -1602059125;

    int charsStart(byte[] data, int startIndex) {
        int index = startIndex;
        while (--index > 0) {
            byte datum = data[index];
            if (datum < 32 || datum > 126) {
                break;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9163().charsStart(data, startIndex));
    }
}
