import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_13955 {

    static int i = 0;

    static boolean ignore = false;

    static int[] array = new int[10];

    int m14(int[] array, int i, boolean ignore) {
        int res = 0;
        res += array[i];
        res += array[i - 2];
        res += array[i];
        res += array[i - 1];
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13955().m14(array, i, ignore));
    }
}
