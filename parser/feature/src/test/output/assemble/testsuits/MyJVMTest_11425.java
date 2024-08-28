public class MyJVMTest_11425 {

    static int v = 0;

    void foo() {
        if (v != 0)
            throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11425().foo();
    }
}
