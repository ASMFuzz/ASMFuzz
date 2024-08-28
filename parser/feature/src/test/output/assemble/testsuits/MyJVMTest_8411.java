public class MyJVMTest_8411 {

    static byte i = 127;

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
        System.out.println(new MyJVMTest_8411().simpleb_deop(i));
    }
}
