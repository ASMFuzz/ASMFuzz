public class MyJVMTest_7664 {

    static long src1 = 9223372036854775807L;

    int tzcntq(long src1) {
        return Long.numberOfTrailingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7664().tzcntq(src1));
    }
}
