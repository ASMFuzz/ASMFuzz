public class MyJVMTest_14045 {

    static int a = -1209558786;

    static int b = 8;

    boolean test_isGt(int a, int b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14045().test_isGt(a, b));
    }
}
