public class MyJVMTest_17077 {

    static int a = 9;

    static int b = 0;

    boolean test_isGe(int a, int b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17077().test_isGe(a, b));
    }
}
