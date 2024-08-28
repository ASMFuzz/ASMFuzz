public class MyJVMTest_13038 {

    static byte i = 122;

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
        System.out.println(new MyJVMTest_13038().testb_deop(i));
    }
}
