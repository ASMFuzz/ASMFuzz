public class MyJVMTest_18207 {

    static byte i = 127;

    Byte foob(byte i) {
        return Byte.valueOf(i);
    }

    void dummy() {
    }

    byte simplef_deop(byte i) {
        Byte ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18207().simplef_deop(i));
    }
}
