public class MyJVMTest_4345 {

    static long a = 0;

    static long b = 9223372036854775807L;

    long test_sub(long a, long b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4345().test_sub(a, b));
    }
}
