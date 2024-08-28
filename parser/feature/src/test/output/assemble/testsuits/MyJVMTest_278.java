public class MyJVMTest_278 {

    static byte i = 0;

    byte testb(byte i) {
        Byte ib = i;
        if ((i & 1) == 0)
            ib = (byte) (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_278().testb(i));
    }
}
