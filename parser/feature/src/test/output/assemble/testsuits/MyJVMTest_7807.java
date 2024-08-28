public class MyJVMTest_7807 {

    static long v = -9223372036854775808L;

    long test(long v) {
        return v * Long.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7807().test(v));
    }
}
