public class MyJVMTest_2191 {

    static byte i = -48;

    static Byte ibc = new Byte((byte) 1);

    byte simplec2(byte i) {
        Byte ib1 = ibc;
        Byte ib2 = Byte.valueOf((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2191().simplec2(i));
    }
}
