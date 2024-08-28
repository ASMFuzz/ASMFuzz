public class MyJVMTest_2450 {

    static long value = -9223372036854775808L;

    long checkMethod(long value) {
        return Math.incrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2450().checkMethod(value));
    }
}
