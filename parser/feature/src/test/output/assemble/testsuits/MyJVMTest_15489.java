public class MyJVMTest_15489 {

    static byte i = 0;

    byte foo(byte i) {
        return i;
    }

    void dummy() {
    }

    byte simple_deop(byte i) {
        Byte ib = new Byte(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15489().simple_deop(i));
    }
}
