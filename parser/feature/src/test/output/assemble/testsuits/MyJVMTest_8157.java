public class MyJVMTest_8157 {

    static long x = 9223372036854775807L;

    long signExtractLong3(long x) {
        return (x >> 63) >>> 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8157().signExtractLong3(x));
    }
}
