public class MyJVMTest_11786 {

    void foo() {
    }

    void method() {
        new Dummy() {

            void foo() {
            }
        }.foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11786().foo();
    }
}
