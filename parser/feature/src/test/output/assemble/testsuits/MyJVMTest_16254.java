public class MyJVMTest_16254 {

    void f() {
    }

    void g() {
        f();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16254().g();
    }
}
