public class MyJVMTest_12478 {

    static byte[] a = { -2, -39, -122, 108, 23, -99, 33, -26, -25, 16 };

    static Byte result2 = 125;

    byte sump2(byte[] a, Byte result2) {
        Byte result1 = 1;
        for (Byte i : a) {
            result1 = (byte) (result1 + i);
            result2 = (byte) (result2 + i + 1);
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12478().sump2(a, result2));
    }
}
