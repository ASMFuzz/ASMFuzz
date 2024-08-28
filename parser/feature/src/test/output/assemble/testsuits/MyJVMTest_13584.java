public class MyJVMTest_13584 {

    static byte i = 0;

    Byte foob(byte i) {
        return Byte.valueOf(i);
    }

    byte simplef(byte i) {
        Byte ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13584().simplef(i));
    }
}
