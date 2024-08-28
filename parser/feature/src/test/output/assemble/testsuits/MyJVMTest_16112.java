public class MyJVMTest_16112 {

    static Local z = null;

    void f() {
        class Local {
        }
        class Inner {

            Local z;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16112().f();
    }
}
