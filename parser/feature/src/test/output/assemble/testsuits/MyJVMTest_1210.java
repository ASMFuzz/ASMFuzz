import java.util.Arrays;

public class MyJVMTest_1210 {

    Object[] s_ref_array_method() {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1210().s_ref_array_method()));
    }
}
