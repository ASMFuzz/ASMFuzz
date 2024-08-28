public class MyJVMTest_5456 {

    static long v = 9223372036854775807L;

    long test2(long v) {
        return v * Long.MIN_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5456().test2(v));
    }
}
