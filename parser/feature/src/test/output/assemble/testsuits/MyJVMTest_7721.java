public class MyJVMTest_7721 {

    static long a = -8617910512690585611L;

    static long b = 0;

    long test_rem(long a, long b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7721().test_rem(a, b));
    }
}
