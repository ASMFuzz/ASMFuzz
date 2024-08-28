public class MyJVMTest_3268 {

    static byte b = 66;

    long test(byte b) {
        return b << 24 & 0xff000000L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3268().test(b));
    }
}
