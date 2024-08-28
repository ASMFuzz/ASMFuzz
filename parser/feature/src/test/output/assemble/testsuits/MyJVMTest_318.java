public class MyJVMTest_318 {

    static String var_1 = "abc";

    void test() {
        new Test7125879().var_1 = ((Test7125879) (new Object[-1])[0]).var_1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_318().test();
    }
}
