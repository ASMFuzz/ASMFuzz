public class MyJVMTest_886 {

    static int a = -301002584;

    static int b = 9;

    boolean test_isLt(int a, int b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_886().test_isLt(a, b));
    }
}
