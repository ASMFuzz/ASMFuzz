public class MyJVMTest_12317 {

    static long a = 6491116679095025199L;

    static long b = 9223372036854775807L;

    long test_mul(long a, long b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12317().test_mul(a, b));
    }
}
