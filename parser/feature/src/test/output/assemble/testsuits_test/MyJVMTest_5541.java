public class MyJVMTest_5541 {

    static int a = 0;

    static int b = 6;

    boolean test_isNe(int a, int b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5541().test_isNe(a, b));
    }
}
