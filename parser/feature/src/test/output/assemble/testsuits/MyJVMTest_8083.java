public class MyJVMTest_8083 {

    static int i = j = 1;

    static int j = -217212499;

    void f() {
        if (i != j)
            throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8083().f();
    }
}
