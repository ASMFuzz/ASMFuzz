public class MyJVMTest_1532 {

    static byte[] a = { -30, -112, 127, 43, -25, 8, -28, 99, 66, -109 };

    byte summ2(byte[] a) {
        Byte result1 = 1;
        Byte result2 = new Byte((byte) 1);
        for (Byte i : a) {
            result1 = (byte) (result1 + i);
            result2 = (byte) (result2 + new Byte((byte) (i + 1)));
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1532().summ2(a));
    }
}
