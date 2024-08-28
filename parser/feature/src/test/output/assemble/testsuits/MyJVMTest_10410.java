import java.util.Arrays;

public class MyJVMTest_10410 {

    Object[] s_ref_array_method() {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10410().s_ref_array_method()));
    }
}
