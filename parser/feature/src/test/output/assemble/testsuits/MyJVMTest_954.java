public class MyJVMTest_954 {

    void foo() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_954().foo();
    }
}
