public class MyJVMTest_12836 {

    static int a = 0;

    boolean test_isLtC(int a) {
        return a < 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12836().test_isLtC(a));
    }
}
