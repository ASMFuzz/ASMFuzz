public class MyJVMTest_7101 {

    static byte i = 127;

    byte simpleb2(byte i) {
        Byte ib1 = Byte.valueOf(i);
        Byte ib2 = Byte.valueOf((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7101().simpleb2(i));
    }
}
