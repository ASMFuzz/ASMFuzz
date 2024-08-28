import java.util.Arrays;

public class MyJVMTest_1865 {

    static Object[] obja = { -1861219175, 1, -1313452344, 1, -1274272905, 8, 5, 6, -1077856501, 4 };

    Object[] s_ref_array_par_method(Object[] obja) {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1865().s_ref_array_par_method(obja)));
    }
}
