public class MyJVMTest_8082 {

    static int p = 0;

    static int r = 0;

    void m() {
        p = 1;
        r = 2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8082().m();
    }
}
