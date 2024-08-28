import java.util.Arrays;

public class MyJVMTest_1597 {

    static Object[] obja = { 4, 1705764001, 0, 6, -199184072, 0, 1246200218, 1, 8, 7 };

    Object[] i_ref_array_par_method(Object[] obja) {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1597().i_ref_array_par_method(obja)));
    }
}
