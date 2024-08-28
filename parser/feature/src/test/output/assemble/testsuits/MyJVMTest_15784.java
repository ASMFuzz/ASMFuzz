public class MyJVMTest_15784 {

    static int a = 4;

    boolean test_isGtC(int a) {
        return a > 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15784().test_isGtC(a));
    }
}
