public class MyJVMTest_11253 {

    int tzcomp(long l) {
        return Long.numberOfTrailingZeros(l);
    }

    static long VALUE = 1724591383672259328L;

    int dotzcomp() {
        return tzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11253().dotzcomp());
    }
}
