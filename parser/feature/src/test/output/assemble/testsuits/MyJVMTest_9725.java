public class MyJVMTest_9725 {

    void foo() {
    }

    void test() {
        Runnable r = () -> (foo());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9725().test();
    }
}
