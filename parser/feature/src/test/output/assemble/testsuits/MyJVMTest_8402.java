public class MyJVMTest_8402 {

    static int var = 0;

    void foo() {
        var *= 2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8402().foo();
    }
}
