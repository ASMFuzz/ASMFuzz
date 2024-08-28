public class MyJVMTest_10751 {

    static byte[] a = { 86, -80, 2, -18, 108, 12, -102, 56, 84, 29 };

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
        System.out.println(new MyJVMTest_10751().summ2(a));
    }
}
