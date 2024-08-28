public class MyJVMTest_16260 {

    static int a = 0;

    static int b = 0;

    static int c = 0;

    void test1() throws Exception {
        (a) = (b) = 1;
        if (a != 1 || b != 1) {
            throw new Exception("FAILED (11)");
        }
        System.out.println(a + " " + b + " " + c);
        a = b = c;
        if (a != 0 || b != 0) {
            throw new Exception("FAILED (12)");
        }
        System.out.println(a + " " + b + " " + c);
        a = (b) += 5;
        if (a != 5 || b != 5) {
            throw new Exception("FAILED (13)");
        }
        System.out.println(a + " " + b + " " + c);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16260().test1();
    }
}
