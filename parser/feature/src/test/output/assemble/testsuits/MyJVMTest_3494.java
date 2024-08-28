import java.util.Arrays;

public class MyJVMTest_3494 {

    static long[] la = { 2450197406975026083L, 8290162415669496777L, 0, 0, -9223372036854775808L, 0, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L };

    long[] i_prim_array_par_method(long[] la) {
        return new long[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3494().i_prim_array_par_method(la)));
    }
}
