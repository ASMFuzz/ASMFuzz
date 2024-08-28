public class MyJVMTest_3305 {

    static byte i = 127;

    static Byte ibc = new Byte((byte) 1);

    byte testc2(byte i) {
        Byte ib1 = ibc;
        Byte ib2 = (byte) (i + 1);
        if ((i & 1) == 0) {
            ib1 = (byte) (ibc + 1);
            ib2 = (byte) (i + 2);
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3305().testc2(i));
    }
}
