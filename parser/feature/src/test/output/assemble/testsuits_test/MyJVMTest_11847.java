public class MyJVMTest_11847 {

    static byte i = -128;

    static Byte ib1 = 0;

    byte simplep2(byte i, Byte ib1) {
        Byte ib2 = Byte.valueOf((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11847().simplep2(i, ib1));
    }
}
