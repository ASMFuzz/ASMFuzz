public class MyJVMTest_2823 {

    static byte[] theByteArray = { -83, -84, -90, -107, -74, -126, 76, -27, 127, -4 };

    String dumpByteArray(byte[] theByteArray) {
        StringBuilder buf = new StringBuilder();
        for (byte b : theByteArray) {
            buf.append(Integer.toHexString(b));
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2823().dumpByteArray(theByteArray));
    }
}
