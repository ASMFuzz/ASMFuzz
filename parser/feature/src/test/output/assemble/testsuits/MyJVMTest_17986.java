public class MyJVMTest_17986 {

    static int var = 0;

    void foo() {
        var *= 2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17986().foo();
    }
}
