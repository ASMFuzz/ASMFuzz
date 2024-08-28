public class MyJVMTest_12119 {

    static byte[] theByteArray = { 99, -84, -26, 110, -106, -51, 8, 37, -41, -12 };

    String dumpByteArray(byte[] theByteArray) {
        StringBuilder buf = new StringBuilder();
        for (byte b : theByteArray) {
            buf.append(Integer.toHexString(b));
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12119().dumpByteArray(theByteArray));
    }
}
