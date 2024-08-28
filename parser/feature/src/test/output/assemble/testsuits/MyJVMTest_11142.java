public class MyJVMTest_11142 {

    static long a = 0;

    static long b = 0;

    boolean test_isGt(long a, long b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11142().test_isGt(a, b));
    }
}
