import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_17195 {

    static boolean z = true;

    static int[] testValues = {0,2,1,0,6,0,0,4,8,5};

    boolean check(boolean z) {
        if (!z)
            throw new RuntimeException("check failed");
        return z;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17195().check(z);
    }
}
