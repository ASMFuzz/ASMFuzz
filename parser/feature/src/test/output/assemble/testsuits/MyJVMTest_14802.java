public class MyJVMTest_14802 {

    static long l = 9223372036854775807L;

    long i_long_par_method(long l) {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14802().i_long_par_method(l));
    }
}
