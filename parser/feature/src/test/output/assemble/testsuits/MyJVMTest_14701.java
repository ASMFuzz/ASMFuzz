import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_14701 {

    static int x = 6;

    static int[] testValues = {0,8,1,9,498478298,0,9,6,1186886701,2};

    Object coerceToObject(int x) {
        return (x & 0xF) == 0 ? null : new Integer(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14701().coerceToObject(x));
    }
}
