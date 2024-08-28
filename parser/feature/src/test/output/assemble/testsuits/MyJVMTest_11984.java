public class MyJVMTest_11984 {

    static long l = -9223372036854775808L;

    long s_long_par_method(long l) {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11984().s_long_par_method(l));
    }
}
