public class MyJVMTest_11360 {

    static long a = 0;

    static long b = 0;

    boolean test_isLt(long a, long b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11360().test_isLt(a, b));
    }
}
