public class MyJVMTest_4471 {

    static byte i = -128;

    byte foo(byte i) {
        return i;
    }

    void dummy() {
    }

    byte test_deop(byte i) {
        Byte ib = new Byte(foo(i));
        if ((i & 1) == 0)
            ib = foo((byte) (i + 1));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4471().test_deop(i));
    }
}
