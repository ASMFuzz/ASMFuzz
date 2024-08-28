public class MyJVMTest_2013 {

    int tzcomp(long l) {
        return Long.numberOfTrailingZeros(l);
    }

    static long VALUE = 0;

    int dotzcomp() {
        return tzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2013().dotzcomp());
    }
}
