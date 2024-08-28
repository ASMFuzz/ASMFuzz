public class MyJVMTest_5920 {

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
        new MyJVMTest_5920().f();
    }
}
