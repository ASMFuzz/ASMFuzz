import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_3541 {

    static String[] arr = { "O0Ui(20a(;", ")vn(aC.v[x", "=!,kC-Y4=2", "BxkLT;@14+", "(pz3l?@|; ", "8xL$D4|<Rw", "xS<uzb$2k>", "r4rNkx*?YS", "D;HXrktLZ:", "15/fR{%!8#" };

    String[] testCloneObjectArray(String[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3541().testCloneObjectArray(arr)));
    }
}
