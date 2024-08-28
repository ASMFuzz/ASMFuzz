import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_7585 {

    static int x = 8;

    static int[] testValues = {0,8,1,-2011939362,0,0,-1131438827,2,2055966016,4};

    String coerceToString(int x) {
        return (x == 0) ? null : Integer.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7585().coerceToString(x));
    }
}
