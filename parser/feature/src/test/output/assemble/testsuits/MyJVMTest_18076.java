public class MyJVMTest_18076 {

    static int a = 0;

    static int b = 4;

    boolean test_isLe(int a, int b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18076().test_isLe(a, b));
    }
}
