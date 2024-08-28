public class MyJVMTest_2826 {

    static byte i = -128;

    byte simpleb(byte i) {
        Byte ib = Byte.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2826().simpleb(i));
    }
}
