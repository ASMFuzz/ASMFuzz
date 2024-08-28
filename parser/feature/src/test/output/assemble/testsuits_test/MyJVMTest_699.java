public class MyJVMTest_699 {

    static byte i = -7;

    void dummy() {
    }

    static Byte ibc = new Byte((byte) 1);

    byte simplec_deop(byte i) {
        Byte ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_699().simplec_deop(i));
    }
}
