public class MyJVMTest_17396 {

    static byte[] a = { -23, 25, -48, -78, -100, -104, -44, -24, -50, 4 };

    static Byte result = 0;

    byte sump(byte[] a, Byte result) {
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17396().sump(a, result));
    }
}
