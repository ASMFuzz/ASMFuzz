public class MyJVMTest_6616 {

    static Local z = null;

    void f() {
        class Local {
        }
        class Inner {

            Local z;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6616().f();
    }
}
