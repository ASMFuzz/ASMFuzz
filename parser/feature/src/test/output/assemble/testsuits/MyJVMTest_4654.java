public class MyJVMTest_4654 {

    static int a = 1185536461;

    static int b = 0;

    boolean test_isGt(int a, int b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4654().test_isGt(a, b));
    }
}
