public class MyJVMTest_8093 {

    static long i = 9223372036854775807L;

    Long foob(long i) {
        return Long.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8093().foob(i));
    }
}
