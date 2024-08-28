import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_11294 {

    static int i = 0;

    static boolean ignore = true;

    static int[] array = new int[10];

    int m13(int[] array, int i, boolean ignore) {
        int res = 0;
        res += array[i + 3];
        res += array[i + 3];
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11294().m13(array, i, ignore));
    }
}
