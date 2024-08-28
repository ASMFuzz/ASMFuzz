public class MyJVMTest_3179 {

    static int a = 8;

    static int b = 9;

    boolean test_isEq(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3179().test_isEq(a, b));
    }
}
