public class MyJVMTest_3701 {

    static byte i = 0;

    byte foo(byte i) {
        return i;
    }

    void dummy() {
    }

    byte testb_deop(byte i) {
        Byte ib = foo(i);
        if ((i & 1) == 0)
            ib = foo((byte) (i + 1));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3701().testb_deop(i));
    }
}
