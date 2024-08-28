import java.util.Arrays;

public class MyJVMTest_10231 {

    long[] i_prim_array_method() {
        return new long[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10231().i_prim_array_method()));
    }
}
