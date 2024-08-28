public class MyJVMTest_10525 {

    void foo() {
    }

    void bar() {
        foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10525().bar();
    }
}
