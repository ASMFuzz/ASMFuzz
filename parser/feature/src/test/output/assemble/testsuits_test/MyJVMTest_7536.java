public class MyJVMTest_7536 {

    static int a = 2;

    static int b = 8;

    boolean test_isGe(int a, int b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7536().test_isGe(a, b));
    }
}
