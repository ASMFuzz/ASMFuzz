import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_9419 {

    static int x = 0;

    static int[] testValues = {4,-2144870954,9,0,1789840847,4,1,0,3,593289870};

    Integer coerceToInteger(int x) {
        return (x == 0) ? null : x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9419().coerceToInteger(x));
    }
}
