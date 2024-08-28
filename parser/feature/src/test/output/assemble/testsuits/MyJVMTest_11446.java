import java.util.Arrays;

public class MyJVMTest_11446 {

    static long[] la = { -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, 9223372036854775807L, 0, -9223372036854775808L, 0, -9223372036854775808L };

    long[] s_prim_array_par_method(long[] la) {
        return new long[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11446().s_prim_array_par_method(la)));
    }
}
