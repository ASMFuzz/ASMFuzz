public class MyJVMTest_7453 {

    static long x = 9223372036854775807L;

    long signExtractLong2(long x) {
        return (x >> 54) >>> 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7453().signExtractLong2(x));
    }
}
