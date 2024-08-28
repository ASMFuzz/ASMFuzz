public class MyJVMTest_1319 {

    void foo() {
    }

    void bar() {
        foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1319().bar();
    }
}
