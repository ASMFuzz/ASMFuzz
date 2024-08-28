public class MyJVMTest_12495 {

    static int a = 1316483979;

    static int b = 3;

    boolean test_isEq(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12495().test_isEq(a, b));
    }
}
