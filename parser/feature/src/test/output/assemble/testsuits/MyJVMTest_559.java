public class MyJVMTest_559 {

    void foo() {
    }

    void test() {
        Runnable r = () -> (foo());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_559().test();
    }
}
