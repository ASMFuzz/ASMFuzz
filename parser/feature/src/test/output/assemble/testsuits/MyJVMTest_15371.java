public class MyJVMTest_15371 {

    void f() {
        class Inner {
        }
        new Object() {

            {
                new Inner();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15371().f();
    }
}
