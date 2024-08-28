public class MyJVMTest_14059 {

    static byte[] a = { -102, 41, 22, 120, -39, -8, 89, -81, -75, 125 };

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
        System.out.println(new MyJVMTest_14059().sumb2(a));
    }
}
