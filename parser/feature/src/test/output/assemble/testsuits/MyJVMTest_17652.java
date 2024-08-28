public class MyJVMTest_17652 {

    static int i = j = 1;

    static int j = 4;

    void f() {
        if (i != j)
            throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17652().f();
    }
}
