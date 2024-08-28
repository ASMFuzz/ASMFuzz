public class MyJVMTest_7486 {

    void bar() {
    }

    void foo() {
        MyUnresolvedClass.bar();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7486().foo();
    }
}
