import java.util.Arrays;

public class MyJVMTest_17962 {

    Object[] i_ref_array_method() {
        return new Object[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17962().i_ref_array_method()));
    }
}
