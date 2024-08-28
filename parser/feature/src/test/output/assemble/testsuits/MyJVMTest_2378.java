import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_2378 {

    static Object x = 0;

    static Object y = 3;

    static int[] testValues = {1277969121,1313505200,1,7,4,292220634,-521264845,0,3,7};

    boolean eq(Object x, Object y) {
        return x == null ? y == null : x.equals(y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2378().eq(x, y));
    }
}
