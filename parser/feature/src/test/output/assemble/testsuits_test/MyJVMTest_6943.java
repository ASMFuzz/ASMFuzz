public class MyJVMTest_6943 {

    static byte i = 127;

    Byte foob(byte i) {
        return Byte.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6943().foob(i));
    }
}
