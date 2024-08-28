public class MyJVMTest_10932 {

    void test() {
        Runnable r1 = () -> {
            new Inner();
        };
        r1.run();
        Runnable r2 = () -> {
            new Inner() {
            };
        };
        r2.run();
        Runnable r3 = () -> {
            class SubInner extends Inner {
            }
            ;
            new SubInner();
        };
        r3.run();
        Runnable r4 = () -> {
            class SubInner extends Inner {
            }
            ;
            new SubInner() {
            };
        };
        r4.run();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10932().test();
    }
}
