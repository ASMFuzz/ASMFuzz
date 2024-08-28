public class MyJVMTest_1820 {

    int lzcomp(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    static long VALUE = 9223372036854775807L;

    int dolzcomp() {
        return lzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1820().dolzcomp());
    }
}
