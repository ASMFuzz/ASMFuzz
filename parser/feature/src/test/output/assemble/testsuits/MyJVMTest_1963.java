public class MyJVMTest_1963 {

    static int v = 0;

    static int v2 = -533502390;

    void m1() {
        v2 = v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1963().m1();
    }
}
