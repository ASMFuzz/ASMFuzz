public class MyJVMTest_7028 {

    static long l = 9223372036854775807L;

    int fcomp(long l) {
        return Long.bitCount(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7028().fcomp(l));
    }
}
