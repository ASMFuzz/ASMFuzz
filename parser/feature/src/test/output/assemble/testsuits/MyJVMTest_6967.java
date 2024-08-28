public class MyJVMTest_6967 {

    static byte i = -9;

    byte test2(byte i) {
        Byte ib1 = new Byte(i);
        Byte ib2 = new Byte((byte) (i + 1));
        if ((i & 1) == 0) {
            ib1 = new Byte((byte) (i + 1));
            ib2 = new Byte((byte) (i + 2));
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6967().test2(i));
    }
}
