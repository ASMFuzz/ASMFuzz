public class MyJVMTest_10232 {

    static int a = 0;

    static int b = 0;

    static int c = 0;

    static int sa = 0;

    static int sb = 0;

    static int sc = 0;

    void test2() throws Exception {
        sa = sb = 1;
        if (sa != 1 || sb != 1) {
            throw new Exception("FAILED (21)");
        }
        System.out.println(sa + " " + sb + " " + sc);
        sa = sb = sc;
        if (sa != 0 || sb != 0) {
            throw new Exception("FAILED (22)");
        }
        System.out.println(sa + " " + sb + " " + sc);
        sa = sb += 5;
        if (sa != 5 || sb != 5) {
            throw new Exception("FAILED (23)");
        }
        System.out.println(sa + " " + sb + " " + sc);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10232().test2();
    }
}
