public class MyJVMTest_6306 {

    static int a = 8;

    boolean test_isGtC(int a) {
        return a > 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6306().test_isGtC(a));
    }
}
