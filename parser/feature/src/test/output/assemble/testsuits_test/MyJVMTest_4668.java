public class MyJVMTest_4668 {

    static byte[] a = { 75, -20, -4, 94, 115, -49, -128, -60, 112, -70 };

    byte sumb2(byte[] a) {
        Byte result1 = 1;
        Byte result2 = 1;
        for (Byte i : a) {
            result1 = (byte) (result1 + i);
            result2 = (byte) (result2 + i + 1);
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4668().sumb2(a));
    }
}
