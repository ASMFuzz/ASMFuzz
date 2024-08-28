public class MyJVMTest_14441 {

    static byte i = 0;

    byte simple2(byte i) {
        Byte ib1 = new Byte(i);
        Byte ib2 = new Byte((byte) (i + 1));
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14441().simple2(i));
    }
}
