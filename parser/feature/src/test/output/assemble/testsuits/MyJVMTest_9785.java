import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_9785 {

    static int x = 0;

    static int[] testValues = {0,7,6,0,2,2,-619542239,-281377571,1979823194,0};

    boolean coerceToBoolean(int x) {
        return (x & 1) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9785().coerceToBoolean(x));
    }
}
