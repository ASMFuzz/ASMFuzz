public class MyJVMTest_10556 {

    static long[] la = new long[] { 0x12345678abcdefL };

    int fint(long[] la) {
        return Long.bitCount(la[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10556().fint(la));
    }
}
