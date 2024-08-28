public class MyJVMTest_12576 {

    static byte i = -128;

    byte testm(byte i) {
        Byte ib = i;
        if ((i & 1) == 0)
            ib = new Byte((byte) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12576().testm(i));
    }
}
