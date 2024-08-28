public class MyJVMTest_4298 {

    static long l = 9223372036854775807L;

    int lzint(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4298().lzint(l));
    }
}
