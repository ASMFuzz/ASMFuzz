public class MyJVMTest_14976 {

    static int a = 0;

    static int b = 2;

    boolean test_isNe(int a, int b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14976().test_isNe(a, b));
    }
}
