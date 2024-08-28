public class MyJVMTest_66 {

    static byte i = -128;

    byte test(byte i) {
        Byte ib = new Byte(i);
        if ((i & 1) == 0)
            ib = (byte) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_66().test(i));
    }
}
