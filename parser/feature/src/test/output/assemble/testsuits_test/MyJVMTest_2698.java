public class MyJVMTest_2698 {

    static long l = 0;

    long s_long_par_method(long l) {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2698().s_long_par_method(l));
    }
}
