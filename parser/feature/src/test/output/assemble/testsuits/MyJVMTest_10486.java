import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_10486 {

    static int i = 4;

    static boolean ignore = false;

    static int[] m15_dummy = new int[10];

    static int[] array = new int[10];

    int m15(int[] array, int i, boolean ignore) {
        int res = 0;
        res += array[i];
        int[] array2 = m15_dummy;
        int j = 0;
        for (; j < 10; j++) ;
        if (j == 10) {
            array2 = array;
        }
        res += array2[i - 2];
        res += array2[i];
        res += array2[i - 1];
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10486().m15(array, i, ignore));
    }
}
