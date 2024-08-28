public class MyJVMTest_9771 {

    void foo() {
    }

    void useDeprecated() {
        deprecated.foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9771().useDeprecated();
    }
}
