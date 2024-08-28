public class MyJVMTest_10325 {

    static long x = 9223372036854775807L;

    long signExtractLong4(long x) {
        return 0 - (x >> 63);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10325().signExtractLong4(x));
    }
}
