public class MyJVMTest_13669 {

    static long l = -9223372036854775808L;

    int lzint(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13669().lzint(l));
    }
}
