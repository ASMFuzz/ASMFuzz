import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_11803 {

    static Object[] a = { 7, 5, 2043235677, 0, -443127152, -662160944, -1684999789, 0, 7, 0 };

    static int m = 1240483348;

    static int n = 0;

    static int[] testValues = {0,-797500620,1213074244,-2138488087,3,3,-1650241742,9,2,0};

    Integer[] copyOfIntegerArrayRange(Object[] a, int m, int n) {
        return Arrays.copyOfRange(a, m, n, Integer[].class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11803().copyOfIntegerArrayRange(a, m, n)));
    }
}
