public class MyJVMTest_11444 {

    static byte i = 127;

    static Byte ibc = new Byte((byte) 1);

    byte simplec2(byte i) {
        Byte ib1 = ibc;
        Byte ib2 = Byte.valueOf((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11444().simplec2(i));
    }
}
