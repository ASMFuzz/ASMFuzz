public class MyJVMTest_11772 {

    static long expect = -9223372036854775808L;

    long check_d2l(long expect) {
        double check = expect;
        check *= 2;
        long actual = (long) check;
        if (actual != expect) {
            throw new RuntimeException("expecting " + expect + ", got " + actual);
        }
        return expect;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11772().check_d2l(expect);
    }
}
