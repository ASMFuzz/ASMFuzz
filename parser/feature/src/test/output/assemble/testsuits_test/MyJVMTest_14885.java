public class MyJVMTest_14885 {

    static long v = -9223372036854775808L;

    long test2(long v) {
        return v * Long.MIN_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14885().test2(v));
    }
}
