public class MyJVMTest_10067 {

    static int a = -477469660;

    static int b = 0;

    boolean test_isLt(int a, int b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10067().test_isLt(a, b));
    }
}
