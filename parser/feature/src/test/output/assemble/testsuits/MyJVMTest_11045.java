public class MyJVMTest_11045 {

    int lzcomp(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    static long VALUE = 3927380076832499561L;

    int dolzcomp() {
        return lzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11045().dolzcomp());
    }
}
