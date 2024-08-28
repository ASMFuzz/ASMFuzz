public class MyJVMTest_12912 {

    static byte i = 0;

    byte testb2(byte i) {
        Byte ib1 = i;
        Byte ib2 = (byte) (i + 1);
        if ((i & 1) == 0) {
            ib1 = (byte) (i + 1);
            ib2 = (byte) (i + 2);
        }
        return (byte) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12912().testb2(i));
    }
}
