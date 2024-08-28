public class MyJVMTest_7836 {

    static byte[] a = { 53, -59, 46, -33, 11, -28, 29, -114, -17, 7 };

    static Byte result = 127;

    byte sump(byte[] a, Byte result) {
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7836().sump(a, result));
    }
}
