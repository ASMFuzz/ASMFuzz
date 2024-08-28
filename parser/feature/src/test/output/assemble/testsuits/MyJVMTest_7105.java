public class MyJVMTest_7105 {

    static long expect = 7179353366874280054L;

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
        new MyJVMTest_7105().check_f2l(expect);
    }
}
