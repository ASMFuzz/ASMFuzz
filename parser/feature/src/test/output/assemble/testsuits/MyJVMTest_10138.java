public class MyJVMTest_10138 {

    void foo() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10138().foo();
    }
}
