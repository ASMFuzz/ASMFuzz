public class MyJVMTest_14370 {

    static int expect = 3;

    int check_d2i(int expect) {
        double check = expect;
        check *= 2;
        int actual = (int) check;
        if (actual != expect) {
            throw new RuntimeException("expecting " + expect + ", got " + actual);
        }
        return expect;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14370().check_d2i(expect);
    }
}
