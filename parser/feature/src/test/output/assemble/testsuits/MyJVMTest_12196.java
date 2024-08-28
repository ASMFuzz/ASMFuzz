public class MyJVMTest_12196 {

    void f() {
        class Local {
        }
        new Local();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12196().f();
    }
}
