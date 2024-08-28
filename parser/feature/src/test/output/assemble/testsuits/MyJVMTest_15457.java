public class MyJVMTest_15457 {

    static int i = 1;

    static int p = 0;

    static int r = 0;

    void m() {
        p = 1;
        r = 2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15457().m();
    }
}
