public class MyJVMTest_16988 {

    static long x = 0;

    long signExtractLong2(long x) {
        return (x >> 54) >>> 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16988().signExtractLong2(x));
    }
}
