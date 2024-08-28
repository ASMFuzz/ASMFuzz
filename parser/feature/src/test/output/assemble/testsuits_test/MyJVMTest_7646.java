import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_7646 {

    static boolean z = false;

    static int[] testValues = {8,6,1,1388675944,-1212490892,6,6,-376154954,2,0};

    boolean check(boolean z) {
        if (!z)
            throw new RuntimeException("check failed");
        return z;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7646().check(z);
    }
}
