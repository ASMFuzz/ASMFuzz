public class MyJVMTest_10598 {

    static long x = 0;

    long signExtractLong1(long x) {
        return (x >> 1) >>> 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10598().signExtractLong1(x));
    }
}
