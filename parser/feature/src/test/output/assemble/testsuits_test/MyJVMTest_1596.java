public class MyJVMTest_1596 {

    static byte i = 54;

    static Byte ib = -128;

    byte testp(byte i, Byte ib) {
        if ((i & 1) == 0)
            ib = new Byte((byte) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1596().testp(i, ib));
    }
}
