public class MyJVMTest_9873 {

    static byte i = 127;

    void dummy() {
    }

    static Byte ibc = new Byte((byte) 1);

    byte simplec_deop(byte i) {
        Byte ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9873().simplec_deop(i));
    }
}
