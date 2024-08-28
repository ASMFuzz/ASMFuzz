public class MyJVMTest_1444 {

    static long a = 222414699213596104L;

    static long b = -9223372036854775808L;

    long unchecked(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1444().unchecked(a, b));
    }
}
