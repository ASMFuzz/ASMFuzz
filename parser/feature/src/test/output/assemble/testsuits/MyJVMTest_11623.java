public class MyJVMTest_11623 {

    static int sideEffect = 0;

    void test() {
        sideEffect++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11623().test();
    }
}
