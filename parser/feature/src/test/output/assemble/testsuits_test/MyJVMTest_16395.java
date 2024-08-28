public class MyJVMTest_16395 {

    static long l = -9223372036854775808L;

    int lzcomp(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16395().lzcomp(l));
    }
}
