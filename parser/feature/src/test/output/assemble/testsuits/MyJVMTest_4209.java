public class MyJVMTest_4209 {

    static byte i = 0;

    byte simple(byte i) {
        Byte ib = new Byte(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4209().simple(i));
    }
}
