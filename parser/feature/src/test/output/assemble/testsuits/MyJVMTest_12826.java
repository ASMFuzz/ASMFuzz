import java.util.Arrays;

public class MyJVMTest_12826 {

    static long[] la = { 3675736352589372493L, 0, 4445992208170908601L, 5420779098270169880L, 0, 5305542029427455063L, -9223372036854775808L, -3989884954773663820L, -9223372036854775808L, -341813021672047067L };

    long[] i_prim_array_par_method(long[] la) {
        return new long[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12826().i_prim_array_par_method(la)));
    }
}
