public class MyJVMTest_1130 {

    static long x = -9223372036854775808L;

    long signExtractLong4(long x) {
        return 0 - (x >> 63);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1130().signExtractLong4(x));
    }
}
