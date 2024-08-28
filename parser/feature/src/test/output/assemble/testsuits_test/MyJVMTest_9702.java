public class MyJVMTest_9702 {

    static long a = -9223372036854775808L;

    static long b = 995161911176815139L;

    static long c = 0;

    long test(long a, long b, long c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9702().test(a, b, c));
    }
}
