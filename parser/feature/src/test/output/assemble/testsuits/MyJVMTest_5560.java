public class MyJVMTest_5560 {

    static long l = -9223372036854775808L;

    int tzint(long l) {
        return Long.numberOfTrailingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5560().tzint(l));
    }
}
