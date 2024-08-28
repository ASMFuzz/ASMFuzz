public class MyJVMTest_1030 {

    void e1() throws E1 {
    }

    void e2() throws E2 {
    }

    void m() {
        try {
            e1();
            e2();
        } catch (final E1 | E2 e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1030().m();
    }
}
