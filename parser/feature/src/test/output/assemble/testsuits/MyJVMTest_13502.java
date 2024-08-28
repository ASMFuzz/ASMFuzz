public class MyJVMTest_13502 {

    static byte i = -128;

    static Byte ibc = new Byte((byte) 1);

    byte testc(byte i) {
        Byte ib = ibc;
        if ((i & 1) == 0)
            ib = new Byte((byte) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13502().testc(i));
    }
}
