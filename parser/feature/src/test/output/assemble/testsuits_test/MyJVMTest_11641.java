import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_11641 {

    static Object x = 0;

    static Object y = 0;

    static int[] testValues = {0,-1392113485,0,-793209034,279271969,0,7,0,0,6};

    boolean eq(Object x, Object y) {
        return x == null ? y == null : x.equals(y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11641().eq(x, y));
    }
}
