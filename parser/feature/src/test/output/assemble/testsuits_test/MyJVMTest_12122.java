public class MyJVMTest_12122 {

    static byte i = -128;

    byte simpleb(byte i) {
        Byte ib = Byte.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12122().simpleb(i));
    }
}
