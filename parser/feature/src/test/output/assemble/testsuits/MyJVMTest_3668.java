public class MyJVMTest_3668 {

    void f() {
    }

    void h() {
        f();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3668().h();
    }
}
