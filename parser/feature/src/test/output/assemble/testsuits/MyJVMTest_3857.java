public class MyJVMTest_3857 {

    static byte i = 127;

    byte testm2(byte i) {
        Byte ib1 = new Byte(i);
        Byte ib2 = (byte) (i + 1);
        if ((i & 1) == 0) {
            ib1 = new Byte((byte) (i + 1));
            ib2 = (byte) (i + 2);
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3857().testm2(i));
    }
}
