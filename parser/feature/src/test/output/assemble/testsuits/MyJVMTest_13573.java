public class MyJVMTest_13573 {

    static byte i = 127;

    byte simple(byte i) {
        Byte ib = new Byte(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13573().simple(i));
    }
}
