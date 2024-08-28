public class MyJVMTest_9208 {

    static byte i = 0;

    byte test(byte i) {
        Byte ib = new Byte(i);
        if ((i & 1) == 0)
            ib = (byte) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9208().test(i));
    }
}
