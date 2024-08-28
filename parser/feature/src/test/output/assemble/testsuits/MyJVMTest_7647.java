public class MyJVMTest_7647 {

    static long a = -9223372036854775808L;

    static long b = 0;

    long checkMethod(long a, long b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7647().checkMethod(a, b));
    }
}
