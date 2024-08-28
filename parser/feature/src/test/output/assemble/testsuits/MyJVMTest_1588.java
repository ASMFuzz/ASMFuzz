public class MyJVMTest_1588 {

    static byte i = 0;

    static Byte ib1 = 0;

    byte testp2(byte i, Byte ib1) {
        Byte ib2 = (byte) (i + 1);
        if ((i & 1) == 0) {
            ib1 = new Byte((byte) (i + 1));
            ib2 = (byte) (i + 2);
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1588().testp2(i, ib1));
    }
}
