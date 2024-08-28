public class MyJVMTest_17215 {

    static long src1 = -9223372036854775808L;

    int tzcntq(long src1) {
        return Long.numberOfTrailingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17215().tzcntq(src1));
    }
}
