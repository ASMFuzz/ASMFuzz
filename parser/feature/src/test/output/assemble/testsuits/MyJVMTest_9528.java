public class MyJVMTest_9528 {

    static byte[] a = { 31, 31, 37, 30, 51, 79, -72, -81, -11, 116 };

    static Byte ibc = new Byte((byte) 1);

    byte sumc2(byte[] a) {
        Byte result1 = 1;
        Byte result2 = ibc;
        for (Byte i : a) {
            result1 = (byte) (result1 + i);
            result2 = (byte) (result2 + i + ibc);
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9528().sumc2(a));
    }
}
