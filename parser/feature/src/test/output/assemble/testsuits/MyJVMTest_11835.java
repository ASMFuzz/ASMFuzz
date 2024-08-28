public class MyJVMTest_11835 {

    void foo() {
        final int i;
        assert true : i = 3;
        i = 4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11835().foo();
    }
}
