import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_618 {

    static int x = -688332373;

    static int[] testValues = {662176541,0,0,2,-821419432,0,0,0,7,7};

    boolean coerceToBoolean(int x) {
        return (x & 1) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_618().coerceToBoolean(x));
    }
}
