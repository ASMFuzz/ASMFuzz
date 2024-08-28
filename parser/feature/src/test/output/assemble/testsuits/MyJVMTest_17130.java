import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_17130 {

    static int x = 249851889;

    static int[] testValues = {0,5,-334638736,0,511493052,0,7,1,7,9};

    String coerceToString(int x) {
        return (x == 0) ? null : Integer.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17130().coerceToString(x));
    }
}
