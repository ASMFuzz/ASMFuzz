public class MyJVMTest_16624 {

    static long expect = 0;

    long check_f2l(long expect) {
        float check = expect;
        check *= 2;
        long actual = (long) check;
        if (actual != expect) {
            throw new RuntimeException("expecting " + expect + ", got " + actual);
        }
        return expect;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16624().check_f2l(expect);
    }
}
