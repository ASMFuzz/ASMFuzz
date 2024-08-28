import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_13623 {

    static Object[] a = { 3, 9, 0, 0, 0, 3, 0, 0, 3, 9 };

    static int len = 6;

    static int[] testValues = {0,1,8,3,5,2,2,9,0,0};

    Integer[] copyOfIntegerArray(Object[] a, int len) {
        return Arrays.copyOf(a, len, Integer[].class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13623().copyOfIntegerArray(a, len)));
    }
}
