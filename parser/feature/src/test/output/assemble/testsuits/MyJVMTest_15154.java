import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_15154 {

    static String[] arr = { "\\<iafmV.%,", "2Iv+puj?fj", "R}toqseJE9", "E3q`qOnQlN", "C:H_Cey:s&", "0.SS@oBmeS", "j_^GaS/i;-", "**Gfk o^!t", "8_4qAF~0m ", "Y?GL\"Ehs82" };

    String[] testCloneObjectArrayCopy(String[] arr) {
        String[] arr2 = new String[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15154().testCloneObjectArrayCopy(arr)));
    }
}
