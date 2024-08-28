import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_9125 {

    static String[] arr = { "zsslfSY0i.", "t\"gPB{+a <", "5/?iK!V7`l", "Hy44bHY'Fh", ";fov^Pi<^>", "|]-KSymd!+", "-YE^Y*m|G-", "/NH#d9[cjw", "a1SH+W~%.Q", "Lh@1|pOs\"6" };

    String[] testCloneObjectArray(String[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9125().testCloneObjectArray(arr)));
    }
}
