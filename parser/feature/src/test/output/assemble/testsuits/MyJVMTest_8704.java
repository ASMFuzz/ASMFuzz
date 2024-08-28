public class MyJVMTest_8704 {

    static byte[] data = { -99, 1, 44, -15, -27, 46, 21, -18, -103, -64 };

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
        System.out.println(new MyJVMTest_8704().charsStart(data, startIndex));
    }
}
