public class MyJVMTest_11717 {

    static long value = -9223372036854775808L;

    long checkMethod(long value) {
        return Math.incrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11717().checkMethod(value));
    }
}
