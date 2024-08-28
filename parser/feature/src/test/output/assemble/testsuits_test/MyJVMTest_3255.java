public class MyJVMTest_3255 {

    static byte i = 0;

    byte testm(byte i) {
        Byte ib = i;
        if ((i & 1) == 0)
            ib = new Byte((byte) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3255().testm(i));
    }
}
