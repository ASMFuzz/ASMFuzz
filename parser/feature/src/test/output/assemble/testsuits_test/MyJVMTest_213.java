import java.util.Arrays;

public class MyJVMTest_213 {

    long[] s_prim_array_method() {
        return new long[100];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_213().s_prim_array_method()));
    }
}
