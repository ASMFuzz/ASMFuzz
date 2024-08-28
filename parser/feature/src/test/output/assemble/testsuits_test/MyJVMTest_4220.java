public class MyJVMTest_4220 {

    static byte i = 33;

    Byte foob(byte i) {
        return Byte.valueOf(i);
    }

    byte simplef(byte i) {
        Byte ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4220().simplef(i));
    }
}
