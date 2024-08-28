public class MyJVMTest_604 {

    void foo() {
    }

    void useDeprecated() {
        deprecated.foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_604().useDeprecated();
    }
}
