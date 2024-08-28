public class MyJVMTest_17995 {

    static byte i = 0;

    byte foo(byte i) {
        return i;
    }

    void dummy() {
    }

    byte simpleb_deop(byte i) {
        Byte ib = Byte.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17995().simpleb_deop(i));
    }
}
