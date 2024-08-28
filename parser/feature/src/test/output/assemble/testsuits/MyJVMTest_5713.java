import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_5713 {

    static String[] arr = { "!cb,r1$.\"H", "l_Xv)}k81C", "rN@X<r!2{G", "`;)!|kgaz ", "#Y}6@&JF,Y", "^v~/^(;?}:", "nC& e3t)s&", "~`:I9_gL9\"", "]\\ |$Fi^,?", "+Mu&xSX!,E" };

    String[] testCloneObjectArrayCopy(String[] arr) {
        String[] arr2 = new String[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5713().testCloneObjectArrayCopy(arr)));
    }
}
