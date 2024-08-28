public class MyJVMTest_10809 {

    static byte i = 0;

    static Byte ib1 = 127;

    byte testp2(byte i, Byte ib1) {
        Byte ib2 = (byte) (i + 1);
        if ((i & 1) == 0) {
            ib1 = new Byte((byte) (i + 1));
            ib2 = (byte) (i + 2);
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10809().testp2(i, ib1));
    }
}
