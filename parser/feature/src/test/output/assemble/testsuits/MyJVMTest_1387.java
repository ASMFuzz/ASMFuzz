public class MyJVMTest_1387 {

    static long x = 3159974579233897910L;

    long signExtractLong1(long x) {
        return (x >> 1) >>> 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1387().signExtractLong1(x));
    }
}
