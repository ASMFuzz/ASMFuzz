public class MyJVMTest_12590 {

    static byte b = 0;

    long test(byte b) {
        return b << 24 & 0xff000000L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12590().test(b));
    }
}
