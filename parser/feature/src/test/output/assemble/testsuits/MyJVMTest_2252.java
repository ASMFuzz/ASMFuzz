public class MyJVMTest_2252 {

    static long[] la = new long[] { 0x12345678abcdefL };

    int fcomp(long[] la) {
        return Long.bitCount(la[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2252().fcomp(la));
    }
}
