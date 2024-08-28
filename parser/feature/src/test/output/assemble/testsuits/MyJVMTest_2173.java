public class MyJVMTest_2173 {

    static int v = 3;

    void foo() {
        if (v != 0)
            throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2173().foo();
    }
}
