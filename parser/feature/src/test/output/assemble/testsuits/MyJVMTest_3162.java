public class MyJVMTest_3162 {

    static byte[] a = { 22, -57, -120, 60, 110, 95, 25, -112, 94, -2 };

    static Byte result2 = -128;

    byte sump2(byte[] a, Byte result2) {
        Byte result1 = 1;
        for (Byte i : a) {
            result1 = (byte) (result1 + i);
            result2 = (byte) (result2 + i + 1);
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3162().sump2(a, result2));
    }
}
