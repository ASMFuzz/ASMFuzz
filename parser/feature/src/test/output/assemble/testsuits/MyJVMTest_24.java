public class MyJVMTest_24 {

    static byte[] data = { 79, -21, 31, -46, -79, 91, 5, -33, 55, 63 };

    static int startIndex = 2;

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
        System.out.println(new MyJVMTest_24().charsStart(data, startIndex));
    }
}
