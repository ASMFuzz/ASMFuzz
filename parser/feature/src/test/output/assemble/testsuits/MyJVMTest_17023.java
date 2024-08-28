public class MyJVMTest_17023 {

    void bar() {
    }

    void foo() {
        MyUnresolvedClass.bar();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17023().foo();
    }
}
