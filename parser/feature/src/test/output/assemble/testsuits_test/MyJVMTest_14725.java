import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_14725 {

    static int i = 0;

    static boolean ignore = true;

    static int[] array = new int[10];

    int m16(int[] array, int i, boolean ignore) {
        int res = 0;
        res += array[i];
        res += array[i - 1];
        res += array[i - 1];
        res += array[i - 2];
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14725().m16(array, i, ignore));
    }
}
