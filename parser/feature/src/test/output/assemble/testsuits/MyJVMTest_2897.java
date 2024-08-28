public class MyJVMTest_2897 {

    void f() {
        class Local {
        }
        new Local();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2897().f();
    }
}
