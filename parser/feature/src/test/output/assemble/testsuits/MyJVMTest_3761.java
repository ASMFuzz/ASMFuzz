public class MyJVMTest_3761 {

    static long var_1 = -1;

    void test() {
        long var_2 = var_1 * 1;
        var_2 = var_2 + (new byte[1])[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3761().test();
    }
}
