import java.util.Arrays;

public class MyJVMTest_10818 {

    static Object[] obja = { 4, 7, 7, 1596928377, 5, 7, -493299977, 2, 0, 0 };

    Object[] i_ref_array_par_method(Object[] obja) {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10818().i_ref_array_par_method(obja)));
    }
}
