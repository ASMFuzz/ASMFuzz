public class MyJVMTest_13847 {

    static Object next = 9;

    void test() {
        new TargetType34<>(next == null ? null : null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13847().test();
    }
}
