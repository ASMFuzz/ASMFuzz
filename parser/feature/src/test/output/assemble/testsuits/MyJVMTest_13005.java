public class MyJVMTest_13005 {

    void f() {
    }

    void h() {
        f();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13005().h();
    }
}
