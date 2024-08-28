public class MyJVMTest_8486 {

    static int a = 0;

    static int b = 0;

    boolean test_isLe(int a, int b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8486().test_isLe(a, b));
    }
}
