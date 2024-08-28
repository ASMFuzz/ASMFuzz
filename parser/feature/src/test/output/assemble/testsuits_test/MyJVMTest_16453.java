public class MyJVMTest_16453 {

    static byte i = -128;

    Byte foob(byte i) {
        return Byte.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16453().foob(i));
    }
}
