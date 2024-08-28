public class MyJVMTest_15797 {

    static long a = 0;

    static long b = 3104557136140580939L;

    static long c = 0;

    long test(long a, long b, long c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15797().test(a, b, c));
    }
}
