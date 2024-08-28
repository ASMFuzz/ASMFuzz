public class MyJVMTest_2501 {

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
        new MyJVMTest_2501().check_d2l(expect);
    }
}
