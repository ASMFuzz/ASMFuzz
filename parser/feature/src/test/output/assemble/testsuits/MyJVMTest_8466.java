public class MyJVMTest_8466 {

    static int expect = 0;

    int check_f2i(int expect) {
        float check = expect;
        check *= 2;
        int actual = (int) check;
        if (actual != expect) {
            throw new RuntimeException("expecting " + expect + ", got " + actual);
        }
        return expect;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8466().check_f2i(expect);
    }
}
