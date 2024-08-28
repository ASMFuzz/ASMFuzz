public class MyJVMTest_5240 {

    static byte i = -128;

    byte simplem2(byte i) {
        Byte ib1 = new Byte(i);
        Byte ib2 = Byte.valueOf((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5240().simplem2(i));
    }
}
