import java.util.Arrays;

public class MyJVMTest_11094 {

    static Object[] obja = { 288720368, 0, 0, -865582668, 0, 5, 0, 661093721, 1959239381, 8 };

    Object[] s_ref_array_par_method(Object[] obja) {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11094().s_ref_array_par_method(obja)));
    }
}
