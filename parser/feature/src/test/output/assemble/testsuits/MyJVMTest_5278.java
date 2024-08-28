import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_5278 {

    static int x = 735973040;

    static int[] testValues = {4,4,0,4,0,0,0,9,4,9};

    Object coerceToObject(int x) {
        return (x & 0xF) == 0 ? null : new Integer(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5278().coerceToObject(x));
    }
}
