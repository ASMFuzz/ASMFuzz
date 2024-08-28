public class MyJVMTest_2559 {

    void foo() {
        final int i;
        assert true : i = 3;
        i = 4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2559().foo();
    }
}
