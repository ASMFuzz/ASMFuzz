public class MyJVMTest_2515 {

    void foo() {
    }

    void method() {
        new Dummy() {

            void foo() {
            }
        }.foo();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2515().foo();
    }
}
