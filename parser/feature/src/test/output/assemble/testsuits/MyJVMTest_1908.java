public class MyJVMTest_1908 {

    static long a = 9223372036854775807L;

    static long b = 9223372036854775807L;

    boolean test_isGt(long a, long b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1908().test_isGt(a, b));
    }
}
