public class MyJVMTest_6661 {

    static long a = 9223372036854775807L;

    static long b = 9223372036854775807L;

    long test_xor(long a, long b) {
        return a ^ b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6661().test_xor(a, b));
    }
}
