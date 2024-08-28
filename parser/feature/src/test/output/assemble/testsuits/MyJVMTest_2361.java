public class MyJVMTest_2361 {

    static int sideEffect = 0;

    void test() {
        sideEffect++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2361().test();
    }
}
