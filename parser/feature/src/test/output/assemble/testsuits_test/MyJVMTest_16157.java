public class MyJVMTest_16157 {

    static long a = 3671178407605572009L;

    static long b = 0;

    long test_xor(long a, long b) {
        return a ^ b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16157().test_xor(a, b));
    }
}
