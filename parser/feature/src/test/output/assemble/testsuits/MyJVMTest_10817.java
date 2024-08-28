public class MyJVMTest_10817 {

    static byte i = 0;

    static Byte ib = 101;

    byte testp(byte i, Byte ib) {
        if ((i & 1) == 0)
            ib = new Byte((byte) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10817().testp(i, ib));
    }
}
